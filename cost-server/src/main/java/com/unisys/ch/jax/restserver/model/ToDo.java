package com.unisys.ch.jax.restserver.model;

import java.util.Calendar;

public class ToDo {
	Long id;
	String title;
	Boolean done;
	Calendar lastModified;
	
	public ToDo() {
		super();
	}

	public ToDo(Long id, String title, Boolean done, Calendar lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.done = done;
		this.lastModified = lastModified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	public Calendar getLastModified() {
		return lastModified;
	}

	public void setLastModified(Calendar lastModified) {
		this.lastModified = lastModified;
	}

}
