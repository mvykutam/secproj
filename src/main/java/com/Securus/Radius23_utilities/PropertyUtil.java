package com.Securus.Radius23_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertyUtil {
	public static void main(String[] s)
	{
		
	}
	
	static private FileInputStream fis;
	static private Properties prop;
	
	public static String getValuforKey(String key)
	{
		String value=null;
		try {
			fis = new FileInputStream(new File("./Data.properties"));
			prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		System.out.println("Issue is in reading ");
		}
		
		return value;
	}
	
	public static String getValuforKey(String filepath,String key)
	{
		String value=null;
		try {
			fis = new FileInputStream(new File(filepath));
			prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Issue is in reading ");
		}
		
		
		return value;
		
	}
	

}
