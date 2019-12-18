package com.igeek.domain;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.igeek.utils.jdbcUtil;

@SuppressWarnings("unused")
public class sentenceOpt {
	
	/*添加*/
	public boolean save(sentence b) throws SQLException {
				//获取连接
				Connection conn = jdbcUtil.getConnection();
				//获取处理命令
				String sql = "insert into sentence(title,category,content,beauty)values (?,?,?,?)";
				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setInt(1,b.getId());
				ps.setString(1,b.getTitle());
				ps.setString(2, b.getCategory());
				ps.setString(3,b.getContent());
				ps.setString(4,b.getBeauty());
			
				
				
				int i = ps.executeUpdate();
				ps.close();
				conn.close();
				return i > 0 ? true : false;
	}
	/** 删除 */
	/*根据id删除标签*/
	public void delete() throws SQLException {
		//获取连接
		Connection conn = jdbcUtil.getConnection();
		//获取处理命令
		String sql = "truncate table sentence";
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = ps.executeUpdate();
		ps.close();
		conn.close();
	}

//	/** 从数据库查询 */
//	测试数据库
//	/*根据id查询标签*/
	@Test
	public void query() throws SQLException {
		//获取连接
		Connection conn = jdbcUtil.getConnection();
		//获取处理命令
		String sql = "select * from sentence";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){

        int id = rs.getInt("id");

        String name = rs.getString("title");

        System.out.println("id:"+id+" 姓名："+name);

    }

		ps.close();
		conn.close();
	}
}
