/**
 * 
 */
package com.ztc.springB.service;

import java.util.List;
import java.util.Map;

import com.ztc.springB.model.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
public interface IUserService {
    List<User> getList();

    void saveExcel(MultipartFile file, String uuid) throws InterruptedException;

    Integer insertList(Map<String, Long> map);

}
