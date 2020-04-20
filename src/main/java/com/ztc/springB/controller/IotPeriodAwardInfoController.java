package com.ztc.springB.controller;

import com.ztc.springB.model.IotPeriodAwardInfo;
import com.ztc.springB.service.IotPeriodAwardInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (IotPeriodAwardInfo)表控制层
 *
 * @author makejava
 * @since 2020-04-11 16:41:39
 */
@RestController
@RequestMapping("/iotPeriodAwardInfo")
public class IotPeriodAwardInfoController {
    /**
     * 服务对象
     */
    @Resource
    private IotPeriodAwardInfoService iotPeriodAwardInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public IotPeriodAwardInfo selectOne(Integer id) {
        return iotPeriodAwardInfoService.queryById(id);
    }
}