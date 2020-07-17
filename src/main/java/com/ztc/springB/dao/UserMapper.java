/**
 * 
 */
package com.ztc.springB.dao;

import com.ztc.springB.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Mapper
public interface UserMapper {

	List<User> getList();

	Integer insertList(@Param(value = "map")Map<String, Long> map);

	void insertUser(User user);
}
