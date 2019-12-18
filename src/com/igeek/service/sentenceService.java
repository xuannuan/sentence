package com.igeek.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.igeek.dao.sentenceDao;
import com.igeek.domain.sentence;;

public class sentenceService {
	
	private sentenceDao tenceDao = new sentenceDao();
	
	/**
	 * 查询所有的文章类别信息
	 * @return
	 */
	public String queryCategory() {
		List<String> list = tenceDao.queryCategory();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 查询相同category文章信息
	 * @param category
	 */
	public String queryByCategory(String category) {
		List<sentence> pList = tenceDao.queryByCategory(category);
		return JSON.toJSONString(pList);
	}
	
	/**
	 * 查询文章内容
	 * @param title
	 * @return
	 */
	public String queryDetailById(String id) {
		sentence tence = tenceDao.queryDetailById(id);
		return JSON.toJSONString(tence);
	}

}
