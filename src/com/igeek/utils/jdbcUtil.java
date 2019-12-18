package com.igeek.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;


public class jdbcUtil {

	//����
	/** ���ݿ�������·�� **/
	private static final String DRIVER_CLASS =  "com.mysql.jdbc.Driver";
	/** url��ַ  192.168.32.125 **/
	private static final String URL = "jdbc:mysql://localhost:3306/beauty?characterEncoding=utf8";
	/** ���ݿ��û��� **/
	private static final String USER ="root";
	/** �����û����� **/
	private static final String PASSWORD = "123456";
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ctrl+shift+x/y ��Сдת��
	 * ��װ���ڻ�ȡ���ݿ����ӷ���
	 * @return �������ݿ�����
	 */
	public static   Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//�ͷ���Դ
	public static void closeResource( Connection connection,Statement statement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(statement != null) {
				statement.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
