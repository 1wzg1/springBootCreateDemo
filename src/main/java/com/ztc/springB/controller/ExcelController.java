package com.ztc.springB.controller;

import com.ztc.springB.bean.ImportAsynInfo;
import com.ztc.springB.bean.User;
import com.ztc.springB.service.IUserService;
import com.ztc.springB.utils.ExcelUtils;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@Controller
public class ExcelController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/poi")
    public String toIndex(){
        return "poi";
    }
    @RequestMapping("/excel/upload")
    public void fileUpload(MultipartFile file) throws IOException {

       // HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
        Workbook workbook = ExcelUtils.getWorkBook(file);
        int numberOfSheets = workbook.getNumberOfSheets();//获得有多少sheet
        System.out.println("numberOfSheets"+"=="+numberOfSheets);
        //默认只有一个sheet
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();//获得sheet有多少行
        System.out.println("rows="+rows);
        //遍历行
        for (int j = 0; j < rows; j++) {
            if (j == 0) {
                continue;//标题行(省略)
            }
            Row row= sheet.getRow(j);
            for (int k = 0; k < row.getPhysicalNumberOfCells(); k++) {
                Cell cell = row.getCell(k);
                System.out.println(cell.toString());
            }
        }
    }
    //生成user表excel
    @GetMapping(value = "/excel/getUser")
    @ResponseBody
    public void getUser(HttpServletResponse response) throws Exception{
        String path = "https://img.sobot.com/exportFile/tenant/20200407/ad629c25781f615e287c3e4c7bc570c5/exportTenant_20200407192206496.xlsx";
        System.out.println(path);
        URL url = new URL(path);
        InputStream input = url.openStream();
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        //XSSFSheet sheet = workbook.createSheet("统计表");
        XSSFSheet sheet = workbook.getSheetAt(0);
        //createTitle(workbook,sheet);
        List<User> rows = new ArrayList<>();//userService.getAll();
        rows.add(new User("1","小明","牛逼",new Date()));
        rows.add(new User("2","中明","牛2逼",new Date()));
        //设置日期格式
        XSSFCellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        //新增数据行，并且设置单元格数据(新增行-1)
        int rowNum=236;
        for(User user:rows){
            XSSFRow row = sheet.createRow(rowNum);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getUsername());
            XSSFCell cell = row.createCell(3);
            cell.setCellValue(user.getCreate_time());
            cell.setCellStyle(style);
            rowNum++;
        }
        String fileName = "导出excel例子.xlsx";
        //生成excel文件
        // buildExcelFile(fileName, workbook);
        //浏览器下载excel
        buildExcelDocument(fileName,workbook,response);
    }
    //创建表头
    private void createTitle(HSSFWorkbook workbook,HSSFSheet sheet){
        HSSFRow row = sheet.createRow(0);
        //设置列宽，setColumnWidth的第二个参数要乘以256，这个参数的单位是1/256个字符宽度
        sheet.setColumnWidth(1,12*256);
        sheet.setColumnWidth(3,17*256);
        //设置为居中加粗
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setFont(font);
        HSSFCell cell;
        cell = row.createCell(0);
        cell.setCellValue("ID");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("显示名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("用户名");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("创建时间");
        cell.setCellStyle(style);
    }
    //生成excel文件
    protected void buildExcelFile(String filename,HSSFWorkbook workbook) throws Exception{
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }
    //浏览器下载excel
    protected void buildExcelDocument(String filename,XSSFWorkbook workbook,HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(filename, "utf-8"));
        OutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    @RequestMapping("/uploadExcel")
    @ResponseBody
    @ApiOperation(value = "导入卡密", notes = "导入卡密")
    public String fileUpload2(MultipartFile file) throws IOException, InterruptedException {
        //检查文件
        if(!ExcelUtils.checkFile(file)){
            System.out.println("excel格式错误！");
        }
        String uuid=ImportAsynInfo.createAsynInfo();
        System.out.println(uuid);
        userService.saveExcel(file,uuid);
        return uuid;
    }
    @RequestMapping("get_import_plan")
    @ResponseBody
    public static Map get_import_plan(String uuid,Integer isStop) {
        Map m = new HashMap<>();
        ImportAsynInfo asynInfo=ImportAsynInfo.getAsynInfo(uuid);
        System.out.println("sssssss="+isStop);
        if(asynInfo!=null&&isStop==1){
            asynInfo.setIsStop(true);
        }
        //如果导入结束,复制进度对象进行返回,将储存的进度对象删除
        if(asynInfo!=null&&asynInfo.getEnd()){
            ImportAsynInfo newAsynInfo=new ImportAsynInfo();
            newAsynInfo.setEnd(asynInfo.getEnd());
            newAsynInfo.setMsg(asynInfo.getMsg());
            newAsynInfo.setErrorFilePath(asynInfo.getErrorFilePath());
            newAsynInfo.setTotality(asynInfo.getTotality());
            newAsynInfo.setDoneSum(asynInfo.getDoneSum());
            newAsynInfo.setErrorSum(asynInfo.getErrorSum());
            newAsynInfo.setSuccessSum(asynInfo.getSuccessSum());
            ImportAsynInfo.deleteAsynInfo(uuid);
            asynInfo=newAsynInfo;
        }
        m.put("data",asynInfo);
        return m;
    }
}
