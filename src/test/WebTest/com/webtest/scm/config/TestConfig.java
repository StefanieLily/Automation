package com.webtest.scm.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class TestConfig {
	private Properties propertie;
	//private FileInputStream inputfile;
	//private BufferedInputStream inputfile;
	private BufferedReader inputfile;
	
	//��ȡ�����ļ�
	public TestConfig(String filepath){
		propertie=new Properties();
			try {
				//inputfile=new FileInputStream(filepath);
				//inputfile=new BufferedInputStream(new FileInputStream(filepath));
				inputfile = new BufferedReader(new InputStreamReader(new  FileInputStream(new File(filepath)), "UTF-8"));
				propertie.load(inputfile);
				inputfile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    catch (IOException e) {
			// TODO Auto-generated catch blocke
			e.printStackTrace();
		}	
	}
    //�õ���Ӧkey��ֵ
	public String getValue(String key){
		if(propertie.containsKey(key)){
			String value=propertie.getProperty(key);
			return value;
		}
		else
			return "";
	}
}
