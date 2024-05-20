package com.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json_Utility {
	public String getDataDromJosnFile(String key) throws Throwable {
		FileReader f = new FileReader("./configAppData/jsoncommandata.json");
		JSONParser jp = new JSONParser();
		Object obj = jp.parse(f);
		JSONObject map= (JSONObject) obj;
		String data = (String)map.get(key);
		return data;
	}
}
