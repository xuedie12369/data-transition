package com.dhcc.service.impl;

import com.dhcc.entity.SiteExcessHandleInfo;
import com.dhcc.dao.SiteExcessHandleInfoDao;
import com.dhcc.service.SiteExcessHandleInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SiteExcessHandleInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-07-23 14:32:39
 */
@Service("siteExcessHandleInfoService")
public class SiteExcessHandleInfoServiceImpl implements SiteExcessHandleInfoService {
    @Resource
    private SiteExcessHandleInfoDao siteExcessHandleInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SiteExcessHandleInfo queryById(Long id) {
        return this.siteExcessHandleInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SiteExcessHandleInfo> queryAllByLimit(int offset, int limit) {
        return this.siteExcessHandleInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SiteExcessHandleInfo insert(SiteExcessHandleInfo siteExcessHandleInfo) {
        this.siteExcessHandleInfoDao.insert(siteExcessHandleInfo);
        return siteExcessHandleInfo;
    }

    /**
     * 修改数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 实例对象
     */
    @Override
    public SiteExcessHandleInfo update(SiteExcessHandleInfo siteExcessHandleInfo) {
        this.siteExcessHandleInfoDao.update(siteExcessHandleInfo);
        return this.queryById(siteExcessHandleInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.siteExcessHandleInfoDao.deleteById(id) > 0;
    }
}