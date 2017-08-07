package com.neusoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class TestInsert {
public static void main(String[] args){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection conn = DriverManager.getConnection(url,"root","root");
		//String sql ="select *from user where username=?and id=?";
		//"占位符"
		String sql="insert into user(username,password)values(?,?)";
		PreparedStatement prestm=conn.prepareStatement(sql);
		//通过setXXX方法给占位符赋值
		prestm.setString(1,"bbb");
		prestm.setString(2,"333");
		//prestm.setString(1,"ada");
		//prestm.setInt(2,3);
		
		//执行插入
	  prestm.executeUpdate();
//	  ResultSet rs = prestm.executeQuery();
//		while(rs.next()){
//			String pass=rs.getString("password");
//			System.out.println(pass);
//		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
