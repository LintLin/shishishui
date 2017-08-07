package com.neusoft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Connection : 代表是连接
 * Statement： 是执行SQL的对象
 * ResultSet ：是查找结果的对象
 */
public class Database {
	private Connection conn;
	private Statement stm; 
	//构造的方法
	public Database(){
		try { 
			//加载mysql数据库的驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//连接mysql数据库,并返回连接对象Connection
			String url = "jdbc:mysql://localhost:3306/mydb";
			conn = DriverManager.getConnection(url, "root", "root");
			//通过连接对象创建Statement对象
			stm = conn.createStatement(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	} 
	//查找的方法
	public ResultSet query(String sql){
		ResultSet rs=null;
		try {
			rs = stm.executeQuery(sql);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return rs;
	}
	//修改、删除、插入的方法
	public void SaveOrUpdateOrDelete(String sql){
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

}
