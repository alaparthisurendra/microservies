package com.moviecatalogservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CatalogItem_tbl")
public class CatalogItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	
	
	private String name;
	

	private String desc;
	
	
	private Integer rating;
	
	public CatalogItem() {
		super();
	}

	
	public CatalogItem(Integer cid, String name, String desc, Integer rating) {
		super();
		this.cid = cid;
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}


	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
