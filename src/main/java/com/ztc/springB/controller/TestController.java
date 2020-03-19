/**
 * 
 */
package com.ztc.springB.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ztc.springB.model.User;
import com.ztc.springB.service.IUserService;

/**
 * @author wangzhiguo
 *
 * 2018年11月7日
 */
@Controller
public class TestController {
	
   @Autowired	
   private IUserService userService;
   
   @RequestMapping("/")
   @ResponseBody
   public String test(){
	return "hello";
   }
   
   @RequestMapping("/jsp")
   public String welcome(Model model) {
	   System.err.println("jsp");
       model.addAttribute("hello", "hello,Jsp!");
       return "hello";
   }
   
   @RequestMapping("/data")
   @ResponseBody
   public List<User> test2(){
	return userService.getList();
   }
   
}
