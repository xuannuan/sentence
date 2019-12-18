package com.igeek.domain;


public class sentence {
	private int id;
	private String title;
	private String category;
	private String content;
	private String beauty;
	
	
	public sentence() {
		super();
	}

	

	public sentence(int id, String title, String category, String content, String beauty) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.content = content;
		this.beauty = beauty;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public String getBeauty() {
		return beauty;
	}



	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}



	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	@Override
	public String toString() {
		return "sentence [id=" + id + ", title=" + title + ", category=" + category + ", content=" + content
				+ ", beauty=" + beauty + "]";
	}







	


	

	
	
	
	
}
