package com.xqxls.mall.domain.ums.service;

import com.xqxls.mall.domain.ums.entity.UmsResource;
import com.xqxls.mall.service.IService;

import java.util.List;


/**
 * 后台资源表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsResourceService extends IService<UmsResource> {

    /**
     * 新增资源
     * @param umsResource 资源
     * @return 成功新增条数
     */
    int create(UmsResource umsResource);

    /**
     * 更新资源
     * @param id 资源ID
     * @param umsResource 资源
     * @return 成功更新条数
     */
    int update(Long id, UmsResource umsResource);

    /**
     * 删除资源
     * @param id 资源ID
     * @return 成功删除条数
     */
    int delete(Long id);

    /**
     * 查询资源分页信息
     * @param categoryId 资源分类ID
     * @param nameKeyword 资源名称搜索关键词
     * @param urlKeyword 资源URL搜索关键词
     * @param page 当前页
     * @param size 每一页记录数
     * @return 资源分页信息
     */
    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer page, Integer size);
}
