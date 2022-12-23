package com.crud.declareinterface;


import org.json.simple.JSONArray;
import org.springframework.stereotype.Component;

import com.crud.model.Model;

@Component
public interface Interface {
	
	public String postMethod(Model value);
	public String deleteMethod(int id);
	public String putMethod(Model value,int id);
	public JSONArray getMethod();
	public JSONArray getidMethod(int id);
	
}
