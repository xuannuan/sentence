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
	
	/*���*/
	public boolean save(sentence b) throws SQLException {
				//��ȡ����
				Connection conn = jdbcUtil.getConnection();
				//��ȡ��������
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
	/** ɾ�� */
	/*����idɾ����ǩ*/
	public void delete() throws SQLException {
		//��ȡ����
		Connection conn = jdbcUtil.getConnection();
		//��ȡ��������
		String sql = "truncate table sentence";
		PreparedStatement ps = conn.prepareStatement(sql);
		int i = ps.executeUpdate();
		ps.close();
		conn.close();
	}

//	/** �����ݿ��ѯ */
//	�������ݿ�
//	/*����id��ѯ��ǩ*/
	@Test
	public void query() throws SQLException {
		//��ȡ����
		Connection conn = jdbcUtil.getConnection();
		//��ȡ��������
		String sql = "select * from sentence";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){

        int id = rs.getInt("id");

        String name = rs.getString("title");

        System.out.println("id:"+id+" ������"+name);

    }

		ps.close();
		conn.close();
	}
}
