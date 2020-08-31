package com.dhcc.service;

import com.dhcc.entity.SiteExcessHandleInfo;
import java.util.List;

/**
 * (SiteExcessHandleInfo)表服务接口
 *
 * @author makejava
 * @since 2020-07-23 14:32:39
 */
public interface SiteExcessHandleInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SiteExcessHandleInfo queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SiteExcessHandleInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 实例对象
     */
    SiteExcessHandleInfo insert(SiteExcessHandleInfo siteExcessHandleInfo);

    /**
     * 修改数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 实例对象
     */
    SiteExcessHandleInfo update(SiteExcessHandleInfo siteExcessHandleInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}