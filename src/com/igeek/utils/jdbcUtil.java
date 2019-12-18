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

	//常量
	/** 数据库驱动类路径 **/
	private static final String DRIVER_CLASS =  "com.mysql.jdbc.Driver";
	/** url地址  192.168.32.125 **/
	private static final String URL = "jdbc:mysql://localhost:3306/beauty?characterEncoding=utf8";
	/** 数据库用户名 **/
	private static final String USER ="root";
	/** 数据用户密码 **/
	private static final String PASSWORD = "123456";
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ctrl+shift+x/y 大小写转换
	 * 封装用于获取数据库连接方法
	 * @return 返回数据库连接
	 */
	public static   Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//释放资源
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
