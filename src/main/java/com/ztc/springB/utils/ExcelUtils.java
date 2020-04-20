package com.ztc.springB.utils;

import com.ztc.springB.dto.AwardInfoExportDTO;
import com.ztc.springB.dto.ExcelToObjectDTO;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelUtils {
    public static Boolean checkFile(MultipartFile file) throws IOException {
        Boolean flag=true;
        //判断文件是否存在
        if(null == file){
            flag=false;
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith("xls") && !fileName.endsWith("xlsx")){
            flag=false;
        }
        return flag;
    }
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {

        }
        return workbook;
    }
    public static String getCellValue(Cell cell){
        String cellValue = "";
        if(cell == null){
            return cellValue;
        }
        //把数字当成String来读，避免出现1读成1.0的情况
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()){
            //数字
            case Cell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            //字符串
            case Cell.CELL_TYPE_STRING:
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            //Boolean
            case Cell.CELL_TYPE_BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            //公式
            case Cell.CELL_TYPE_FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            //空值
            case Cell.CELL_TYPE_BLANK:
                cellValue = "";
                break;
            //故障
            case Cell.CELL_TYPE_ERROR:
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        System.out.println("-------------------------------"+cellValue);
        return cellValue;
    }

    public static ExcelToObjectDTO excelToObject(String[] cells){
        ExcelToObjectDTO excelToObjectDTO = new ExcelToObjectDTO();
        //AwardInfo info = new AwardInfo();
        AwardInfoExportDTO info = new AwardInfoExportDTO();
        Boolean flag=true;
        for(int i = 0 ; i<cells.length; i++){
            switch (i){
                case 0:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    info.setAwardType(cells[i]);
                    break;
                case 1:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    info.setAwardType(info.getAwardType()+"/"+cells[i]);
                    info.setAwardName(cells[i]);
                    break;
                case 2:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    info.setAwardType(info.getAwardType()+"/"+cells[i]);
                    info.setAwardName(info.getAwardName()+cells[i]);
                    break;
                case 3:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    info.setAwardNo(cells[i]);
                    break;
                case 4:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    info.setAwardWord(cells[i]);
                    break;
                case 5:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    /*if(isNumber(cells[i])){
                        Date date = HSSFDateUtil.getJavaDate(Double.parseDouble(cells[i]));
                        String cellValue = new SimpleDateFormat("yyyy/MM/dd").format(date);
                        info.setCardStartTime(cellValue);
                    }else{
                        info.setCardStartTime(cells[i]);
                    }*/
                    info.setCardStartTime(cells[i]);
                    break;
                case 6:
                    if(StringUtils.isEmpty(cells[i])){
                        flag=false;
                    }
                    /*if(isNumber(cells[i])){
                        Date date = HSSFDateUtil.getJavaDate(Double.parseDouble(cells[i]));
                        String cellValue = new SimpleDateFormat("yyyy/MM/dd").format(date);
                        info.setCardEndTime(cellValue);
                    }else{
                        info.setCardEndTime(cells[i]);
                    }*/
                    info.setCardEndTime(cells[i]);
                    break;
                default:
                    break;
            }
        }
        excelToObjectDTO.setFlag(flag);
        excelToObjectDTO.setInfo(info);
        return excelToObjectDTO;
    }

    public static boolean isNumber(String str){
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    public static String parseExcel(Cell cell) {
        String result = new String();
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:// 数字类型
                if (DateUtil.isCellDateFormatted(cell)) {// 处理日期格式、时间格式
                    SimpleDateFormat sdf = null;
                    /*if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                            .getBuiltinFormat("h:mm")) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy/MM/dd");
                    }*/
                    sdf = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = cell.getDateCellValue();
                    result = sdf.format(date);
                } else if (cell.getCellStyle().getDataFormat() == 58) {
                    // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    double value = cell.getNumericCellValue();
                    Date date = org.apache.poi.ss.usermodel.DateUtil
                            .getJavaDate(value);
                    result = sdf.format(date);
                } else {
                    double value = cell.getNumericCellValue();
                    CellStyle style = cell.getCellStyle();
                    DecimalFormat format = new DecimalFormat();
                    String temp = style.getDataFormatString();
                    // 单元格设置成常规
                    if (temp.equals("General")) {
                        format.applyPattern("#");
                    }
                    result = format.format(value);
                }
                break;
            case Cell.CELL_TYPE_STRING:// String类型
                result = cell.getRichStringCellValue().toString();
                break;
            case Cell.CELL_TYPE_BLANK:
                result = "";
            default:
                result = "";
                break;
        }
        System.out.println(result);
        return result;
    }
    public static boolean isDate(String s) {
        Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2}");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()){
            return true;
        }else {
            return false;
        }
    }

}
