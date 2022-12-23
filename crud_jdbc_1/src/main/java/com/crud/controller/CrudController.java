package com.crud.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.dao.Dao;
import com.crud.model.Model;

import org.json.simple.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/controller")
public class CrudController {

	Dao obj=new Dao();
	
	@PostMapping("/post")
	public ResponseEntity<String>postMethod(@RequestBody Model value){
		return ResponseEntity.ok(obj.postMethod(value));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String>deleteMethod(@RequestParam int id){
		return ResponseEntity.ok(obj.deleteMethod(id));
	}
	
	@PutMapping("/put")
	public ResponseEntity<String>putMethod(@RequestBody Model value,@RequestParam int id){
		return ResponseEntity.ok(obj.putMethod(value,id));
	}
	
	@GetMapping("/get")
	public ResponseEntity<JSONArray>getMethod(){
		return ResponseEntity.ok(obj.getMethod());
		}
	
	@GetMapping("/getid")
	public ResponseEntity<JSONArray>getidMethod(int id){
		return ResponseEntity.ok(obj.getidMethod(id));
	}
}
