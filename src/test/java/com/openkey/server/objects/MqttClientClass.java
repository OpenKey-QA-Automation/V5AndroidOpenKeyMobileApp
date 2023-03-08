package com.openkey.server.objects;

import org.eclipse.paho.mqttv5.client.IMqttMessageListener;
import org.eclipse.paho.mqttv5.client.IMqttToken;
import org.eclipse.paho.mqttv5.client.MqttAsyncClient;
import org.eclipse.paho.mqttv5.client.persist.MemoryPersistence;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.eclipse.paho.mqttv5.common.MqttSubscription;
import org.eclipse.paho.mqttv5.common.packet.MqttProperties;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

public class MqttClientClass {
    QNode head;
    QNode tail;
    int size;
    private int position;

    private boolean readyToReceive;
    private boolean lockOpened;
    private String publishTopic;
    private String subscriptionTopic;
    final String serverURI;
    private boolean shouldWait;

    public MqttAsyncClient mqttClient;
    //private boolean inPosition;
    public MqttClientClass(String server, String pTopic, String sTopic) throws MqttException {
        size = 0;
        head = new QNode();
        tail = new QNode();

        this.head.next = this.tail;

        publishTopic = pTopic; subscriptionTopic = sTopic;
        serverURI = server;
        MemoryPersistence persistence = new MemoryPersistence();
        mqttClient = new MqttAsyncClient(serverURI, UUID.randomUUID().toString(), persistence);
        IMqttToken token = mqttClient.connect();
        token.waitForCompletion();
        this.subscribe();
        this.publishCommand(publishTopic, "areYouReady");
    }

    //Getters
    public MqttAsyncClient getClient(){
        return mqttClient;
    }
    //public String getPublishTopic(){ return publishTopic; }
    public String getSubscriptionTopic(){ return subscriptionTopic; }
    public int getPosition(){return position;}
    public boolean getShouldWait(){ return shouldWait; }
    public boolean getLockOpened(){ return lockOpened; }
    public int getSize(){ return size; }
    public boolean getReadyToReceive(){ return readyToReceive; }

    //Setters
    public void setPosition(int newPosition){ this.position = newPosition; }
    public void setShouldWait(boolean newBool){
        this.shouldWait = newBool;
    }
    public void setLockOpened(boolean newBool) { this.lockOpened = newBool; }
    public void setReadyToReceive(boolean newBool){ this.readyToReceive = newBool; }

    //Takes a Topic and message and adds them to the queue
    private void enqueue(String top, String mes){
        QNode temp = new QNode();
        this.tail.topic = top;
        this.tail.message = mes;
        this.tail.next = temp;
        this.tail = temp;
        size++;
        //If ESP is waiting for a command, go ahead a deque/publish
        if(getReadyToReceive()){
            deque();
        }
    }

    //Takes Topic and message from queue and publishes them
    void deque(){
        if(isEmpty()){
            System.out.println("Error: Cannot Deque from an empty queue.");
        }
        else{
            setReadyToReceive(false);
            publishCommand(this.head.next.topic, this.head.next.message);
            this.head.next = this.head.next.next;
            size--;
        }
    }

    //Checks to see if queue is empty
    private boolean isEmpty(){
        return this.head.next == this.tail;
    }

    //Enqueues Command to Esp for phones to move to lock
    public void moveToPosition(int pos) throws InterruptedException {
        if(getPosition() != pos) {
            String messageToPublish = "moveToPosition" + pos;
            System.out.println("Moving Rail to position " + pos);
            enqueue(publishTopic, messageToPublish);
            while(getPosition() != pos){                     //Look into multithreading?
                Thread.sleep(100);
            }
        }
    }
    //Get response from lock                       THIS IS PROBABLY NOT NEEDED, REVISIT ONCE ESP CAN GET LOCK RESPONSE
    public boolean openLock() throws InterruptedException {
        setShouldWait(true);
        setLockOpened(false);
        String messageToPublish = "openLock";
        enqueue(publishTopic, messageToPublish);
        while (getShouldWait()) {  //Change This!
            Thread.sleep(100);
        }

        return getLockOpened();
    }

    //Takes MqttAsyncClient, a Topic and a message and publishes the message
    //Converts String message to a byte[]
    //Called by enqueue(String topic, String message).
    private void publishCommand(String topic, String message){
        byte[] messageToPublish = message.getBytes(StandardCharsets.UTF_8);
        try {
            IMqttToken pub = getClient().publish(topic, messageToPublish, 0, false);
            pub.waitForCompletion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Subscribe to Publish Topic and set Callback commands
    private void subscribe(){
        MqttSubscription topic = new MqttSubscription(getSubscriptionTopic());
        final MqttProperties props = new MqttProperties();

        props.setSubscriptionIdentifiers(Arrays.asList(new Integer[] { 0 })); //Learn why this is necessary
        try {
            IMqttToken subscribe = getClient().subscribe(topic,null,null,  new IMqttMessageListener() {
                @Override
                public void messageArrived(String s, MqttMessage mqttMessage) {//Logic for message Calls
                    String m = new String(mqttMessage.getPayload(), StandardCharsets.UTF_8);//Need to revisit later
                    int code = Integer.parseInt(m);
                    if(code >= 0){
                        responseCallback(code);
                    } else {
                        errorCallback(code);
                    }
                    setShouldWait(false);
                }
            }, props);
            subscribe.waitForCompletion();
        } catch (MqttException exp) {
            exp.printStackTrace();
        }
    }
    //Callback Error Codes
    private void errorCallback(int code){
        switch (code) {
            case -1: setReadyToReceive(false);
                break;
            case -2: setReadyToReceive(false);
                System.out.println("Not in Position");
                break;

        }
    }
    //Callback Response Codes
    private void responseCallback(int code) {
        switch (code) {
            case 99:
                setReadyToReceive(true);
                if (!this.isEmpty()) {
                    deque();
                }
                break;

            case 0: setPosition(0);
                break;
            case 1: setPosition(1);
                break;
            case 2: setPosition(2);
                break;
            case 3: setPosition(3);
                break;
        }
    }
}