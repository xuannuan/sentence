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

public class JsoupTest {
	

	@Test
	public void test5() throws IOException, SQLException {
		sentence b = new sentence();
		ArrayList<sentence> bArr = new ArrayList<sentence>(); 
		
		Document document2=null;
		for (int i = 2; i <=15; i++) {
			
//			String url ="http://www.duwenzhang.com/wenzhang/xiaoyuanwenzhang/list_4_"+i+".html";
//			String url ="http://www.duwenzhang.com/wenzhang/jingdianwenzhang/list_5_"+i+".html";
			String url ="http://www.duwenzhang.com/wenzhang/shenghuosuibi/list_8_"+i+".html";
		
		Document document = Jsoup.connect(url).get();
		// System.out.println(document);

		Element ele = document.select("td.sprite-bluelef2+td[valign='top']").first();
		// System.out.println(ele);
		Elements eles = ele.select("table>tbody");
		for (Element element : eles) {
//			System.out.println(element);
			String subject = element.select("tr:nth-child(2)>td:last-child>b a:first-child").first().text();
			String title = element.select("tr:nth-child(2)>td:last-child>b a:last-child").first().text();
			String content = element.select("tr:last-child td").first().text();
			System.out.println(title);
			b.setTitle(title);
			
//			System.out.println(subject);
			b.setCategory("生活文章");
			
			System.out.println(content);
			b.setContent(content);

		    Element beauty = element.select("tr:nth-child(2)>td:last-child>b >a").last();
			String suburl = beauty.attr("href");
			document2 = Jsoup.connect(suburl).get();
			Elements eles2 = document2.select("div#wenzhangziti > p");
			StringBuffer buffer = new StringBuffer();
			for (Element element2 : eles2) {
				buffer.append(element2.text().toString());
//				System.out.println(element2.text().toString());
			}
			System.out.println(buffer.toString());
			b.setBeauty(buffer.toString());
		   
			bArr.add(b);


//			System.out.println(b);
			
			 sentenceOpt tenceOpt=new sentenceOpt();
			tenceOpt.save(b);
		}
		}
	}
	

//
//	public void test6() throws SQLException{
//
//		sentence b = new sentence();
//		ArrayList<sentence> bArr = new ArrayList<sentence>(); 
//		
//		String url = "http://www.duwenzhang.com/wenzhang/qinqingwenzhang/";
//		Document document=null;
//		Document document2=null;
//		try {
//			document = Jsoup.connect(url).get();
//			Element ele = document.select("td.sprite-bluelef2+td[valign='top']").first();
//			Elements eles = ele.select("table>tbody");
//			for (Element element : eles) {
//				Element subject = element.select("tr:nth-child(2)>td:last-child>b >a").last();
//				String suburl = subject.attr("href");
//				document2 = Jsoup.connect(suburl).get();
//				Elements eles2 = document2.select("div#wenzhangziti > p");
//				StringBuffer buffer = new StringBuffer();
//				for (Element element2 : eles2) {
//					buffer.append(element2.text().toString());
////					System.out.println(element2.text().toString());
//				
//				}
//				System.out.println(buffer.toString());
//				b.setBeauty(buffer.toString());
//				sentenceOpt tenceOpt=new sentenceOpt();
//					System.out.println(b);
//					tenceOpt.save(b);
////				
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// System.out.println(document);
//
//
//	}

}


