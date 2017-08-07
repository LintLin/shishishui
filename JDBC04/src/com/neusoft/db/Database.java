package com.neusoft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * Connection : ����������
 * Statement�� ��ִ��SQL�Ķ���
 * ResultSet ���ǲ��ҽ���Ķ���
 */
public class Database {
	private Connection conn;
	private Statement stm; 
	//����ķ���
	public Database(){
		try { 
			//����mysql���ݿ����������
			Class.forName("com.mysql.jdbc.Driver");
			//����mysql���ݿ�,���������Ӷ���Connection
			String url = "jdbc:mysql://localhost:3306/mydb";
			conn = DriverManager.getConnection(url, "root", "root");
			//ͨ�����Ӷ��󴴽�Statement����
			stm = conn.createStatement(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	} 
	//���ҵķ���
	public ResultSet query(String sql){
		ResultSet rs=null;
		try {
			rs = stm.executeQuery(sql);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return rs;
	}
	//�޸ġ�ɾ��������ķ���
	public void SaveOrUpdateOrDelete(String sql){
		try {
			stm.executeUpdate(sql);
		} catch (SQLException e) { 
			e.printStackTrace();
		}
	}

}
