package com.project.Utilities;

import java.io.*;
import java.util.*;

public class PropertyFileHandler {

	public static String readProperty(String name) {
		
		
		String propertyValue=null;
		try {
			Properties props=new Properties();
			InputStream input=null;
			try {
			input = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			}
			catch (FileNotFoundException e) {
				System.out.println("File name or path name is not correct");
				e.printStackTrace();
			}
			props.load(input);
			propertyValue=props.getProperty(name);
			}  catch (Exception e) {
			System.out.println("Input output error");
			e.printStackTrace();
			}
		return propertyValue;
	}

}
