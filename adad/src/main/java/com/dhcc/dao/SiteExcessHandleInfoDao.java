package com.dhcc.dao;

import com.dhcc.entity.SiteExcessHandleInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SiteExcessHandleInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-23 14:32:39
 */
public interface SiteExcessHandleInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SiteExcessHandleInfo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SiteExcessHandleInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 对象列表
     */
    List<SiteExcessHandleInfo> queryAll(SiteExcessHandleInfo siteExcessHandleInfo);

    /**
     * 新增数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 影响行数
     */
    int insert(SiteExcessHandleInfo siteExcessHandleInfo);

    /**
     * 修改数据
     *
     * @param siteExcessHandleInfo 实例对象
     * @return 影响行数
     */
    int update(SiteExcessHandleInfo siteExcessHandleInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}