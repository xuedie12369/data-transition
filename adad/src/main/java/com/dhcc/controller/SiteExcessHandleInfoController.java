package com.dhcc.controller;

import com.dhcc.entity.SiteExcessHandleInfo;
import com.dhcc.service.SiteExcessHandleInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SiteExcessHandleInfo)表控制层
 *
 * @author makejava
 * @since 2020-07-23 14:32:39
 */
@RestController
@RequestMapping("siteExcessHandleInfo")
public class SiteExcessHandleInfoController {
    /**
     * 服务对象
     */
    @Resource
    private SiteExcessHandleInfoService siteExcessHandleInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SiteExcessHandleInfo selectOne(Long id) {
        return this.siteExcessHandleInfoService.queryById(id);
    }

}