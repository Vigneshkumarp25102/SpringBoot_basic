package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.crud.declareinterface.Interface;
import com.crud.model.Model;

public class Dao implements Interface {

	@Override
	public String postMethod(Model value) {

		String insertquery = "insert into jdbc(username,email,phoneno,password)" + "values('" + value.getUsername()
				+ "','" + value.getEmail() + "','" + value.getPhoneno() + "','" + value.getPassword() + "')";
//		try { 
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kgisl@123"); Statement statement = connection.createStatement();) {
			statement.executeUpdate(insertquery);
			System.out.println(insertquery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	public String deleteMethod(int id) {
		String getquery = "delete from jdbc where id=" + id + "";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kgisl@123"); Statement statement = connection.createStatement();) {
			statement.executeUpdate(getquery);
			System.out.println(getquery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	public String putMethod(Model value, int id) {
		String updatequery = "update jdbc set username='" + value.getUsername() + "',email='" + value.getEmail()
				+ "',phoneno='" + value.getPhoneno() + "',password='" + value.getPassword() + "' where id='" + id + "'";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kgisl@123"); Statement statement = connection.createStatement();) {
			statement.executeUpdate(updatequery);
			System.out.println(updatequery);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Success";
	}

	@SuppressWarnings("unchecked")
	public JSONArray getMethod() {

		JSONArray jsar = new JSONArray();

		String selectquery = "select * from jdbc";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root",
				"Kgisl@123"); Statement statement = connection.createStatement();) {
			ResultSet rs = statement.executeQuery(selectquery);

			while (rs.next()) {
				JSONObject jsob = new JSONObject();
				jsob.put("Name :", rs.getObject("username"));
				jsob.put("Email :", rs.getObject("email"));
				jsob.put("Phone :", rs.getObject("phoneno"));
				jsob.put("password", rs.getObject("password"));
				System.out.println(jsob);
				jsar.add(jsob);
			}
			System.out.println(jsar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsar;
	}

	@SuppressWarnings("unchecked")
	public JSONArray getidMethod(int id) {
		
		JSONArray jsar = new JSONArray();
		JSONObject jsob=new JSONObject();		
		String selectidquery = "select * from jdbc where id='"+id+"'";
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root","Kgisl@123");Statement statement=connection.createStatement();){
			ResultSet rs=statement.executeQuery(selectidquery);
			
			while(rs.next()) {
				jsob.put("Name :",rs.getObject("username"));
				jsob.put("Email",rs.getObject("email"));
				jsob.put("Phoneno :",rs.getObject("phoneno"));
				jsob.put("Password :",rs.getObject("password"));
				System.out.println(jsob);
				jsar.add(jsob);
			}
			System.out.println(jsar);
		}
		catch(Exception e) {
			e.printStackTrace();		
			}
	return jsar;
	}
}

