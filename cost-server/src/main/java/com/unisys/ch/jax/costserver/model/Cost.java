package com.unisys.ch.jax.costserver.model;

import java.util.Calendar;

public class Cost {
	
	Long id;
	String title;
	String description;
	Calendar workDay;
	Double time;
	CostLocation costLocation;

	public Cost() {
		super();
	}

	public Cost(Long id, String title, String description, Calendar workDay,
			Double time, CostLocation costLocation) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.workDay = workDay;
		this.time = time;
		this.costLocation = costLocation;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getWorkDay() {
		return workDay;
	}

	public void setWorkDay(Calendar workDay) {
		this.workDay = workDay;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(Double time) {
		this.time = time;
	}

	public CostLocation getCostLocation() {
		return costLocation;
	}

	public void setCostLocation(CostLocation costLocation) {
		this.costLocation = costLocation;
	}

}