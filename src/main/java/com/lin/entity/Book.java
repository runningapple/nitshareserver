package com.lin.entity;

import java.io.Serializable;

/**
 * 
 * <p>ClassName: Book.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午4:18:48
 */
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1875148957062658052L;
	
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}
	
	
}
