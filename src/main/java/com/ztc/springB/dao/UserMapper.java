/**
 * 
 */
package com.ztc.springB.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ztc.springB.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Mapper
public interface UserMapper {

	List<User> getList();

	Integer insertList(@Param(value = "map")Map<String, Long> map);

}
