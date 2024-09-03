package com.BigbasketDataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	FileInputStream fi ;
	
	public Properties gettheProperty(){
		
		File f = new File("C:\\Users\\A\\Postman\\BigbasketMaven\\src\\main\\java\\com\\BigbasketDataReader\\BigBasketData.properties");
	
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	
		Properties prop = new Properties();
		
		try {
			prop.load(fi);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public String getBrowser() {
		
		String browername = gettheProperty().getProperty("browser");
		
		return browername;

	}
	
	public String getUrl() {
		
		String url = gettheProperty().getProperty("url");
		
		return url;
	}

}
