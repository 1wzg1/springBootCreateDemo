package com.ztc.springB.service;

import com.ztc.springB.model.IotPeriodAwardInfo;

import java.util.List;

/**
 * (IotPeriodAwardInfo)表服务接口
 *
 * @author makejava
 * @since 2020-04-11 16:41:39
 */
public interface IotPeriodAwardInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IotPeriodAwardInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<IotPeriodAwardInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 实例对象
     */
    IotPeriodAwardInfo insert(IotPeriodAwardInfo iotPeriodAwardInfo);

    /**
     * 修改数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 实例对象
     */
    IotPeriodAwardInfo update(IotPeriodAwardInfo iotPeriodAwardInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}