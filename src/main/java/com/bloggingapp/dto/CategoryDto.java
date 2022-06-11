package com.bloggingapp.dto;

import java.sql.Date;

public class CategoryDto {
	 private int id;
	    private String name;
	    private Date onCreated;
	  
	    
	    public CategoryDto(int id, String name, Date onCreated) {
			setId(id);
			setName(name);
			setOnCreated(onCreated);
		}

		public CategoryDto(String name) {
			setName(name);
		}

		public CategoryDto(int id, String name) {
			setId(id);
			setName(name);
		}

		public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }
	    
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
	    public void setOnCreated(Date onCreated) {
	        this.onCreated =onCreated;
	    }
	    
	    public Date getOnCreated() {
	        return onCreated;
	    }
}
