package com.entity;

public class Jobs {

	private String id;
	private String title;
	private String description;
	private String category;
	private String status;
	private String location;
	private String pdate;
	public String getId() {
		return id;
	}
	public void setId(String i) {
		this.id = i;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public Jobs(String id, String title, String description, String category, String status, String location,
			String pdate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.status = status;
		this.location = location;
		this.pdate = pdate;
	}
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Jobs [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", status=" + status + ", location=" + location + ", pdate=" + pdate + "]";
	}
	
		
}
