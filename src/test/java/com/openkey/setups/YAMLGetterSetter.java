package com.openkey.setups;

import java.util.List;

public class YAMLGetterSetter {

    private String name;

    public String getEnvironment() {

        return environment;
    }

    public void setEnvironment(String environment) {

        this.environment = environment;
    }
    private String environment;

    private List<YAMLGetterSetter> desired_capabilities;
    private String type;
    private String os_version;
    private String device;
    private String appPackage;
    private String appActivity;
    private String orientation;
    private int doorLockTotalCount;

    private List<YAMLGetterSetter> credentials;
    private String id;
    private String username;
    private String password;

    public List<YAMLGetterSetter> getDesired_capabilities() {

        return desired_capabilities;
    }

    public void setDesired_capabilities(List<YAMLGetterSetter> desired_capabilities) {

        this.desired_capabilities = desired_capabilities;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getOS_version() {

        return os_version;
    }

    public void setOS_version(String os_version) {

        this.os_version = os_version;
    }

    public String getDevice() {

        return device;
    }

    public void setDevice(String device) {

        this.device = device;
    }

    public String getAppPackage() {

        return appPackage;
    }

    public void setAppPackage(String appPackage) {

        this.appPackage = appPackage;
    }

    public String getAppActivity() {

        return appActivity;
    }

    public void setAppActivity(String appActivity) {

        this.appActivity = appActivity;
    }

    public String getOrientation() {

        return orientation;
    }

    public void setOrientation(String orientation) {

        this.orientation = orientation;
    }

    // Getters and setters
    @Override
    public String toString() {

        return "\nname : " +name + "\ntype: " + type + "\nos_version: " + os_version + "device: " + device + "\ndesired_capabilities: " + desired_capabilities + "\n";
    }

    // Credentials Node in yaml
    public List<YAMLGetterSetter> getCredentials() {

        return credentials;
    }

    public void setCredentials(List<YAMLGetterSetter> credentials) {

        this.credentials = credentials;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getDoorLockTotalCount() {
        return doorLockTotalCount;
    }

    public void setDoorLockTotalCount(int doorLockTotalCount) {
        this.doorLockTotalCount = doorLockTotalCount;
    }

}


