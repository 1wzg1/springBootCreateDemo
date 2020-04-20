package com.ztc.springB.dao;

import com.ztc.springB.model.IotPeriodAwardInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (IotPeriodAwardInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-11 16:41:39
 */
@Mapper
public interface IotPeriodAwardInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    IotPeriodAwardInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<IotPeriodAwardInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 对象列表
     */
    List<IotPeriodAwardInfo> queryAll(IotPeriodAwardInfo iotPeriodAwardInfo);

    /**
     * 新增数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 影响行数
     */
    int insert(IotPeriodAwardInfo iotPeriodAwardInfo);

    /**
     * 修改数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 影响行数
     */
    int update(IotPeriodAwardInfo iotPeriodAwardInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}