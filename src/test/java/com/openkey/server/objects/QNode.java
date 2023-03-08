package com.openkey.server.objects;

class QNode {
    String topic;
    String message;
    QNode next;

    public QNode(){
        this.topic = null;
        this.message = null;
        this.next = null;
    }
}