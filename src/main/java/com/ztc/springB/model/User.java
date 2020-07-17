/**
 * 
 */
package com.ztc.springB.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author wangzhiguo
 *
 * 2018年11月8日
 */
@Data
public class User {
	
    private int id;
    private String name;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date create_time;
    

}
