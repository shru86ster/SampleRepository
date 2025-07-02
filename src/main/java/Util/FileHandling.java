package Util;

import io.cucumber.java.zh_cn.而且;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FileHandling {
    //Read the contents from the json file, with path as parameter
    //return jsoncontent as String
    public static String ReadJson(String filepath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filepath)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Read the properties from json file
    public static String ReadProperties(String filepath, String key) throws IOException {
        String value = null;
        try {
            InputStream input = new FileInputStream(filepath);
            Properties prop1 = new Properties();
            prop1.load(input);
            value = prop1.getProperty(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        return value;
    }
}
