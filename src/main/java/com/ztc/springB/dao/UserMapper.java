/**
 * 
 */
package com.ztc.springB.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ztc.springB.model.User;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Mapper
public interface UserMapper {

	List<User> getList();
	   
}
