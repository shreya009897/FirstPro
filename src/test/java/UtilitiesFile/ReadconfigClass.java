package UtilitiesFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadconfigClass {

	Properties pro;
	String path = "D:\\Shreya_code\\Eclipse_workspace\\MyFirstDDProject\\ConfigurationFile\\Configuration.Properties";
	public ReadconfigClass() {
		FileInputStream fn=null;
		pro = new Properties();
		 try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			pro.load(fn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String geturl() {
		
		String s1 = pro.getProperty("baseurl");
		if(s1!=null) {
			return s1;
		}
		else {
			throw new RuntimeException("url not found");
		}
			
		}
		public String getbrowser() {
			
			String s1 = pro.getProperty("browser");
			if(s1!=null) {
				return s1;
			}
			else {
				throw new RuntimeException("browser not found");
			}
	}
	
	
}
