package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.igeek.domain.sentence;
import com.igeek.utils.C3P0Util;
import com.igeek.utils.DbcpUtils;

public class sentenceDao {
QueryRunner queryRunner = new QueryRunner(DbcpUtils.getDataSource());
	
	/**
	 * 查询文章类别信息
	 */
	public List<String> queryCategory() {
		
		String sql = "SELECT category FROM sentence GROUP BY category";
		List<String> list = null;
		try {
			list = queryRunner.query(sql, new ColumnListHandler<String>("category"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<sentence> queryByCategory(String category) {
		String sql = "SELECT * FROM sentence WHERE category= ? ";
		List<sentence> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<sentence>(sentence.class),category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public sentence queryDetailById(String id) {
		String sql = "SELECT * FROM sentence WHERE id=?";
		sentence tence = null;
		try {
			tence = queryRunner.query(sql, new BeanHandler<sentence>(sentence.class),id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tence;
	}


}
