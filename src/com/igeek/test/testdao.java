package com.igeek.test;

import java.util.List;

import org.junit.Test;

import com.igeek.dao.sentenceDao;
import com.igeek.domain.sentence;

public class testdao {

	@Test
	public void test(){
		sentenceDao dao=new sentenceDao();
	    List<String> list=dao.queryCategory();
	    for (String string : list) {
			System.out.println(string);
		}
	}
	@Test
	public void test2(){
		sentenceDao dao=new sentenceDao();
		List<sentence> list=dao.queryByCategory("Ç×ÇéÎÄÕÂ");
		System.out.println(list.size());
		for (sentence sentence : list) {
			System.out.println(sentence);
		}
	}
	@Test
	public void test3(){
		sentenceDao dao=new sentenceDao();
		sentence list=dao.queryDetailById("75");
		System.out.println(list);
//		for (sentence sentence : list) {
//			System.out.println(sentence);
//		}
	}
}
