/**
 * 
 */
package com.ztc.springB.service;

import java.util.List;

import com.ztc.springB.model.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
public interface IUserService {
	   public List<User> getList();

    void saveExcel(MultipartFile file, String uuid) throws InterruptedException;
}
