package com.neusoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

public class TestSelect {
public static void main(String[] args){
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		Connection conn = DriverManager.getConnection(url,"root","root");
		String sql ="select *from user where username=?and id=?";
		//String sql="insert into user(username,password)values(?,?)";
		PreparedStatement prestm=conn.prepareStatement(sql);
		//通过setXXX方法给占位符赋值
		prestm.setString(1,"admin");
		prestm.setInt(2,1);
		//prestm.setString(1,"ada");
		//prestm.setInt(2,3);
		
		//执行查找
		ResultSet rs = prestm.executeQuery();
		while(rs.next()){
			String pass=rs.getString("password");
			System.out.println(pass);
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
