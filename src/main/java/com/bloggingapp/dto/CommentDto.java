package com.bloggingapp.dto;

import java.sql.Date;

public class CommentDto {
	private int id;
	private String commenter;
	private String comment;
	private int blogIdFk;
	private Date onCreated;

	public CommentDto(int id, int blogIdFk, String commenter, String comment, Date createdOn) {
		setId(id);
		setBlogIdFk(blogIdFk);
		setCommenter(commenter);
		setComment(comment);
		setOnCreated(createdOn);
	}
	public CommentDto(int blogIdFk, String commenter, String comment) {
		setBlogIdFk(blogIdFk);
		setCommenter(commenter);
		setComment(comment);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getBlogIdFk() {
		return blogIdFk;
	}
	public void setBlogIdFk(int blogIdFk) {
		this.blogIdFk = blogIdFk;
	}
	public Date getOnCreated() {
		return onCreated;
	}
	public void setOnCreated(Date onCreated) {
		this.onCreated = onCreated;
	}



}
