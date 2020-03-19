/**
 * 
 */
package com.ztc.springB.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztc.springB.dao.UserMapper;
import com.ztc.springB.model.User;
import com.ztc.springB.service.IUserService;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return userMapper.getList();
	}
    
}
