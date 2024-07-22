package com.example;

import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void main(String[] args) {
        try (InputStream input
		= App.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }

            Properties prop = new Properties();
            prop.load(input);

            System.out.println("App Name: " + prop.getProperty("app.name"));
            System.out.println("App Version: " + prop.getProperty("app.version"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
