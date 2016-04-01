package com.lin.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lin.entity.User;

/**
 * 
 * <p>ClassName: UserDao.java<p>
 * <p>Description<p>
 * @author linzj
 * @createTime 2016年4月1日  下午2:47:20
 */
@Repository("userDao")
public interface UserDao extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {
	/**
	 * 用原生sql语句查询 nativeQuery=true
	 * @param name
	 * @return
	 */
	@Query(value="select * from jpa_user u where u.name=?1", nativeQuery=true)
	public User findByUsername(String name);
	
	/**
	 * 用JPQL语句查询
	 * @param age
	 * @return
	 */
	@Query(value="select u from User u where u.age=:age")
	public User findByUserage(@Param("age") Integer age);
}
