package com.bloggingapp.dto;

import java.sql.Date;

public class BlogDto {
	private int id;
	private String title;
	private String description;
	private int categoryIdFk;
	private String categoryName;
	private Date onCreated;
	public BlogDto(int id, String title, String description, Date createdOn, int categoryId, String categoryName) {
		setId(id);
		setTitle(title);
		setDescription(description);
		setOnCreated(createdOn);
		setCategoryIdFk(categoryId);
		setCategoryName(categoryName);
	}
	public BlogDto(String title, String description, int categoryId) {
		setTitle(title);
		setDescription(description);
		setCategoryIdFk(categoryId);
	}
	public BlogDto(int blogId, String title, String description, int categoryId) {
		setId(blogId);
		setTitle(title);
		setDescription(description);
		setCategoryIdFk(categoryId);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCategoryIdFk() {
		return categoryIdFk;
	}
	public void setCategoryIdFk(int categoryIdFk) {
		this.categoryIdFk = categoryIdFk;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getOnCreated() {
		return onCreated;
	}
	public void setOnCreated(Date onCreated) {
		this.onCreated = onCreated;
	}



}
