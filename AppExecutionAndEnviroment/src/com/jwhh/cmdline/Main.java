package com.jwhh.cmdline;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        /***************************** command line exercises ******************************/
        if(args.length == 0){
            showUsage();
            return;
        }

        String fileName = args[0];
        if(!Files.exists(Paths.get(fileName))) {
            System.out.println("\nFile not found " + fileName);
            return;
        }
        showFileLines(fileName);

        /*****************************Storing Properties as Simple Text***********************/
        /*
        Properties props = new Properties();
        props.setProperty("displayName","Jim Wilson");
        props.setProperty("accountNumber","123-45-6789");

        try(Writer writer = Files.newBufferedWriter(Paths.get("xyz.properties"))){
            props.store(writer, "My comment");

        }catch (IOException e){
            e.getMessage();
        }
         */
        /**************************Loading Properties from Simple Text*********************************/
        /*
        Properties props = new Properties();
        try(Reader reader = Files.newBufferedReader(Paths.get("myapp.properties"))){
            props.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String val1 = props.getProperty("val1");
        String val2 = props.getProperty("val2");
        String val3 = props.getProperty("val3");
        String val4 = props.getProperty("val4");
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
         */
        /*****************************Store Properties as XML******************************/
        /*
        Properties props = new Properties();
        props.setProperty("displayName","Jim Wilson");
        props.setProperty("accountNumber","123-45-678");
        try(OutputStream output = Files.newOutputStream(Paths.get("props.xml"))){
            props.storeToXML(output,"My comment");
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        /*******************************Load Properties from XMl********************************/
        /*
        Properties props = new Properties();
        try(InputStream inputStream = Files.newInputStream(Paths.get("props.xml"))){
            props.loadFromXML(inputStream);
        } catch (IOException e) {
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        String name = props.getProperty("displayName");
        String number = props.getProperty("accountNumber");
        System.out.println("Name and number are: "+ " " + name+ " " + number);
        */
        /*******************************Using Default Properties***************************************/

        Properties defaults = new Properties();
        defaults.setProperty("position","1");
        Properties props = new Properties(defaults);
        String nextPos = props.getProperty("position");
        System.out.println(nextPos);

        int pos = Integer.parseInt(nextPos);
        props.setProperty("position",Integer.toString(++pos));
        String newPos = props.getProperty("position");
        System.out.println(newPos);

    }

    private static void showFileLines(String fileName) {
        System.out.println();
        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))){
            String line = null;
            while((line = reader.readLine())!= null){
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    private static void showUsage(){
        System.out.println();
        System.out.println("Please provide the filename to process on the command line");
    }
}
