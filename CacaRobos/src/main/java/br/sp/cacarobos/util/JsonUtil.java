package br.sp.cacarobos.util;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class JsonUtil{
	private final static Gson gson=new Gson();
	private static String readJson(String url){
		try {
			URL urlToBeRead=new URL(url);
			Scanner in=new Scanner(urlToBeRead.openStream());
			String json="";
			while(in.hasNext()){
				json+=in.nextLine();
			}
			in.close();
			return json;
		} catch (IOException e) {
			throw new RuntimeException("Error in JsonUtil(Read jason): "+e.getMessage());
		}
	}
	
	public static Object reciveAndConvertJsonObject(String url, Object object){
		return gson.fromJson(readJson(url), object.getClass());
	}
	
	public static List<?> reciveAndConvertJsonList(String url){
		return gson.fromJson(readJson(url), List.class);
	}
}
