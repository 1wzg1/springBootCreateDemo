package com.ztc.springB.service.impl;

import com.ztc.springB.model.IotPeriodAwardInfo;
import com.ztc.springB.dao.IotPeriodAwardInfoDao;
import com.ztc.springB.service.IotPeriodAwardInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (IotPeriodAwardInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-11 16:41:39
 */
@Service("iotPeriodAwardInfoService")
public class IotPeriodAwardInfoServiceImpl implements IotPeriodAwardInfoService {
    @Resource
    private IotPeriodAwardInfoDao iotPeriodAwardInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public IotPeriodAwardInfo queryById(Integer id) {
        return this.iotPeriodAwardInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<IotPeriodAwardInfo> queryAllByLimit(int offset, int limit) {
        return this.iotPeriodAwardInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 实例对象
     */
    @Override
    public IotPeriodAwardInfo insert(IotPeriodAwardInfo iotPeriodAwardInfo) {
        this.iotPeriodAwardInfoDao.insert(iotPeriodAwardInfo);
        return iotPeriodAwardInfo;
    }

    /**
     * 修改数据
     *
     * @param iotPeriodAwardInfo 实例对象
     * @return 实例对象
     */
    @Override
    public IotPeriodAwardInfo update(IotPeriodAwardInfo iotPeriodAwardInfo) {
        this.iotPeriodAwardInfoDao.update(iotPeriodAwardInfo);
        return this.queryById(iotPeriodAwardInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.iotPeriodAwardInfoDao.deleteById(id) > 0;
    }
}