package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App 
{
	/** 
	* Javadoc comment.
	*/
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args )
    {
        logger.info("Hello, SLF4J!");
		
		Properties properties = new Properties();
        try (InputStream input 
			= App.class.getClassLoader().getResourceAsStream("config.properties"))
		{
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
            System.out.println("App Name: " + properties.getProperty("app.name"));
            System.out.println("App Version: " + properties.getProperty("app.version"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}
}
