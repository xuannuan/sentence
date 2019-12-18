package com.igeek.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.igeek.domain.sentence;
import com.igeek.domain.sentenceOpt;

public class JsoupTest1 {

	@Test
	public void test5() throws IOException, SQLException {
		sentence b = new sentence();
		ArrayList<sentence> bArr = new ArrayList<sentence>(); 
		
		String url ="http://www.duwenzhang.com/wenzhang/qinqingwenzhang/list_2_38.html";
	
		Document document = Jsoup.connect(url).get();
		// System.out.println(document);

		Element ele = document.select("td.sprite-bluelef2+td[valign='top']").first();
		// System.out.println(ele);
		Elements eles = ele.select("table>tbody");
		int id=189;
		for (Element element : eles) {
			//System.out.println(element);
			String subject = element.select("tr:nth-child(2)>td:last-child>b a:first-child").first().text();
			String title = element.select("tr:nth-child(2)>td:last-child>b a:last-child").first().text();
			String content = element.select("tr:last-child td").first().text();
			System.out.println(title);
			b.setTitle(title);
			
//			System.out.println(subject);
			b.setCategory("Ç×ÇéÎÄÕÂ");
			
			System.out.println(content);
			b.setContent(content);
			
		
			bArr.add(b);
			b.setId(id);
		    id++;
		
		
		sentenceOpt tenceOpt=new sentenceOpt();
		
//		for (sentence sentence : bArr) {
			System.out.println(b);
//			tenceOpt.save(b);
//		}
		}
		
		
	}

//	@Test
//	public void test() throws SQLException{
//sentenceOpt tenceOpt=new sentenceOpt();
//		
//			tenceOpt.query();
//		}
		
	}
	



