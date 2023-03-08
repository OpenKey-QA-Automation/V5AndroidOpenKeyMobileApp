package com.openkey.setups;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;


public class YamlConfigReader {

    protected static String[] desiredCapabilities = new String[7];
    protected static String[] credentials = new String[3];
    private static ClassLoader classLoader;
    private static File file;
    private static ObjectMapper objectmapper;
    private static YAMLGetterSetter yamlGetterSetter;

    public static void inititializeyaml() {

        classLoader = Thread.currentThread().getContextClassLoader();
        //file = new File(Objects.requireNonNull(classLoader.getResource("envds.yaml")).getFile()); (Uncomment for Windows)
        // To run it on Mac machine
        file = new File("src/main/com.openkey.resources/envds.yaml");
        System.out.println(file.getAbsoluteFile());
        objectmapper = new ObjectMapper(new YAMLFactory());

    }

    public static String[] getDesired_capabilities() throws IOException {

        yamlGetterSetter = objectmapper.readValue(file, YAMLGetterSetter.class);
        System.out.println("Name of the Application : " + yamlGetterSetter.getName());
        System.out.println("Environment : " + yamlGetterSetter.getEnvironment());

        desiredCapabilities[0] = yamlGetterSetter.getDesired_capabilities().get(0).getType();
        desiredCapabilities[1] = yamlGetterSetter.getDesired_capabilities().get(0).getOS_version();
        desiredCapabilities[2] = yamlGetterSetter.getDesired_capabilities().get(0).getDevice();
        desiredCapabilities[3] = yamlGetterSetter.getDesired_capabilities().get(0).getAppPackage();
        desiredCapabilities[4] = yamlGetterSetter.getDesired_capabilities().get(0).getAppActivity();
        desiredCapabilities[5] = yamlGetterSetter.getDesired_capabilities().get(0).getOrientation();
        desiredCapabilities[6] = String.valueOf(yamlGetterSetter.getDesired_capabilities().get(0).getDoorLockTotalCount());
        credentials[0] = yamlGetterSetter.getCredentials().get(0).getId();
        credentials[1] = yamlGetterSetter.getCredentials().get(0).getUsername();
        credentials[2] = yamlGetterSetter.getCredentials().get(0).getPassword();
        return desiredCapabilities;

    }

    public static String[] getCredentials() {

        return credentials;
    }
}


