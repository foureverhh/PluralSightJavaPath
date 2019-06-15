package com.foureverhh.www;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try{
            Properties defaultProps = new Properties();
            try(InputStream inputStream = Main.class.getResourceAsStream("MyDefaultValue.xml")){
                defaultProps.loadFromXML(inputStream);
            }
            Properties userProps = new Properties(defaultProps);
            loadUserProperties(userProps);
            String welcome = userProps.getProperty("welcomeMessage");
            String farewell = userProps.getProperty("farewellMessage");
            System.out.println(welcome);
            System.out.println(farewell);

            if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")){
                userProps.setProperty("welcomeMessage","Welcome back.");
                userProps.setProperty("farewellMessage","Things will be familiar now.");
                userProps.setProperty("isFirstRun","N");
                saveUserProps(userProps);
            }

        }catch (IOException e){
            System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage() );
        }
    }

    private static void saveUserProps(Properties userProps) throws IOException {
        Path path = Paths.get("userValues.xml");
        try(OutputStream outputStream = Files.newOutputStream(path)){
            userProps.storeToXML(outputStream, null);
        }
    }

    private static Properties loadUserProperties(Properties userProperties) throws IOException {
        Path userFile = Paths.get("userValues.xml");
        if(Files.exists(userFile)) {
            try (InputStream input = Files.newInputStream(userFile)) {
                userProperties.loadFromXML(input);
            }
        }
        return userProperties;
    }
}

