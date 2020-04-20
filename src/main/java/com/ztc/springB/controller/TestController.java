/**
 * 
 */
package com.ztc.springB.controller;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ztc.springB.model.User;
import com.ztc.springB.service.IUserService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangzhiguo
 *
 * 2018年11月7日
 */
@Controller
@Api("用户信息")
public class TestController {
	
   @Autowired	
   private IUserService userService;
   
   @RequestMapping("/")
   @ResponseBody
   @ApiOperation("获取用户信息")
   public String test(){
	return "hello";
   }
   
   @RequestMapping("/jsp")
   @ApiOperation(value = "定向到jsp页面",notes = "返回到jsp页面")
   public String welcome(Model model) {
	   System.err.println("jsp");
       model.addAttribute("hello", "hello,Jsp!");
       return "hello";
   }
   
   @RequestMapping("/data")
   @ResponseBody
   @ApiImplicitParam(name = "user", value = "单个用户信息", dataType = "User")
   @ApiOperation(value = "获取用户信息",notes = "获取信息")
   public List<User> test2(@RequestParam User user){
      System.out.println(user.getId()+":4444444444,"+user.getName());
      User user1 = new User();
      return userService.getList();
   }
   @GetMapping("/downloadAddCardFtl")
   @ApiOperation("下载导卡OR分配卡模板")
   public void downloadFtl(HttpServletResponse response) {
      try {
         //获取要下载的模板名称
         String fileName = "导出模板.xls";
         //fileName = new String(fileName.getBytes("utf-8"), "utf-8");
         // 设置要下载的文件的名称
         //response.setHeader("Content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Content-disposition", "attachment;filename=aaaa" + URLEncoder.encode(fileName, "UTF-8"));
         // 通知客服文件的MIME类型
         response.setContentType("application/vnd.ms-excel;charset=UTF-8");
         // 获取文件的路径
         String path = "https://img.sobot.com/exportFile/tenant/20200407/ad629c25781f615e287c3e4c7bc570c5/exportTenant_20200407192206496.xlsx";
         System.out.println(path);
         URL url = new URL(path);
         InputStream input = url.openStream();
         //FileInputStream input = new FileInputStream(path);
         OutputStream out = response.getOutputStream();
         byte[] b = new byte[1024];
         int len;
         while ((len = input.read(b)) != -1) {
            out.write(b, 0, len);
         }
         // 修正 Excel在“xxx.xlsx”中发现不可读取的.内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
         //response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
         input.close();
      } catch (Exception e) {
         System.out.println("yichang!");
      }
   }

   @PostMapping("/import")
   public void importData(MultipartFile file) throws IOException {
   }


}
