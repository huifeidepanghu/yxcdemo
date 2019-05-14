package com.sgcc.epri.dataexchangeplatform.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertiesUtil {

	
	public static String getProperty(String fileName, String key) {
		Properties prop = new Properties();
		InputStream in = PropertiesUtil.class.getResourceAsStream(  fileName);
		try {
			 prop.load(new InputStreamReader(in, "utf-8"));  
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String value = prop.getProperty(key);
		return value;

	}
	
	public static void main(String[] args) {
//		String property = PropertiesUtil.getProperty("/zkIP.properties", "zkIP");
		String region=PropertiesUtil.getProperty("/params.properties", "start.time");
		System.out.println(region);
	}
}
