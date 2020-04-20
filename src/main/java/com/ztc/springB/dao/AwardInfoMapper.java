/**
 * 
 */
package com.ztc.springB.dao;

import com.ztc.springB.dto.AwardInfoExportDTO;
import com.ztc.springB.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Mapper
public interface AwardInfoMapper {

	Integer insertAwardInfo(AwardInfoExportDTO awardInfoExportDTO);
	   
}
