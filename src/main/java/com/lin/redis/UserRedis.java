package com.lin.redis;

import com.lin.entity.Book;

/**
 * 
 * <p>ClassName: UserRedis.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午4:19:08
 */
public interface UserRedis {
	public void addOrUpdate(Book user);
	
	public Book load(String id);
	
	public void delete(String id);
}
