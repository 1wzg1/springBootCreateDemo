/**
 * 
 */
package com.ztc.springB.service.impl;

import com.ztc.springB.bean.ImportAsynInfo;
import com.ztc.springB.dao.AwardInfoMapper;
import com.ztc.springB.dao.UserMapper;
import com.ztc.springB.dto.AwardInfoExportDTO;
import com.ztc.springB.dto.ExcelToObjectDTO;
import com.ztc.springB.model.User;
import com.ztc.springB.service.IUserService;
import com.ztc.springB.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AwardInfoMapper awardInfoMapper;
	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return userMapper.getList();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveExcel(MultipartFile file, String uuid) throws InterruptedException {

		//获得Workbook工作薄对象
		Workbook workbook = ExcelUtils.getWorkBook(file);
		//创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		List<AwardInfoExportDTO> trueList = new ArrayList<AwardInfoExportDTO>();
		List<AwardInfoExportDTO> falseList= new ArrayList<AwardInfoExportDTO>();
		if(workbook != null){
			//for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){
			//获得当前sheet工作表
			Sheet sheet = workbook.getSheetAt(0);
			//设置总条数
			ImportAsynInfo.getAsynInfo(uuid).setTotality(sheet.getPhysicalNumberOfRows()-2);
			//获得当前sheet的开始行
			int firstRowNum  = sheet.getFirstRowNum();
			//获得当前sheet的结束行
			int lastRowNum = sheet.getLastRowNum();
			//循环除了第二行的所有行
			for(int rowNum = firstRowNum+2;rowNum <= lastRowNum;rowNum++){
				if(ImportAsynInfo.getAsynInfo(uuid).getIsStop()){
					TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
					System.out.println("事务回滚！");
					break;
				}
				//获得当前行
				Row row = sheet.getRow(rowNum);
				if(row == null){
					continue;
				}
				//获得当前行的开始列
				int firstCellNum = row.getFirstCellNum();
				//获得当前行的列数
				int lastCellNum = row.getPhysicalNumberOfCells();
				String[] cells = new String[row.getPhysicalNumberOfCells()];
				//循环当前行
				for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){
					Cell cell = row.getCell(cellNum);
					//cells[cellNum] = ExcelUtils.getCellValue(cell);
					cells[cellNum] = ExcelUtils.parseExcel(cell);
				}
				ExcelToObjectDTO excelToObjectDTO = ExcelUtils.excelToObject(cells);
				ImportAsynInfo.doneSumAddOne(uuid);
				if(excelToObjectDTO.getFlag()){
					ImportAsynInfo.successSumAddOne(uuid);
					trueList.add(excelToObjectDTO.getInfo());
					if(!ExcelUtils.isDate(excelToObjectDTO.getInfo().getCardStartTime())){
						System.out.println("开始时间格式不正确！");
					}
					if(!ExcelUtils.isDate(excelToObjectDTO.getInfo().getCardEndTime())){
						System.out.println("结束时间格式不正确！");
					}
					awardInfoMapper.insertAwardInfo(new AwardInfoExportDTO());
				}else{
					ImportAsynInfo.errorSumAddOne(uuid);
					falseList.add(excelToObjectDTO.getInfo());
				}
			}
			ImportAsynInfo.getAsynInfo(uuid).setIsEnd(true);
			//}
		}

		Date date = HSSFDateUtil.getJavaDate(43748);
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String format1 = format.format(date);
		System.out.println("sssssssssssssssssssssssss"+format1);
		System.out.println("kkk"+trueList);
		System.out.println("llll"+falseList);
		System.out.println(get_import_plan(uuid).get("data").toString());
	}

	//@RequestMapping("get_import_plan")
	public static Map get_import_plan(String uuid) {
		Map m = new HashMap<>();
		ImportAsynInfo asynInfo=ImportAsynInfo.getAsynInfo(uuid);
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
	@Override
	public Integer insertList(Map<String, Long> map) {
		return userMapper.insertList(map);
	}

	@Override
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

}
