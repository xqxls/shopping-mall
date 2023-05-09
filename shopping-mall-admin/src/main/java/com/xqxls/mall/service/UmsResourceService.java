package com.xqxls.mall.service;

import com.xqxls.mall.entity.UmsResource;

import java.util.List;


/**
 * 后台资源表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsResourceService extends IService<UmsResource> {

    int create(UmsResource umsResource);

    int update(Long id, UmsResource umsResource);

    int delete(Long id);

    List<UmsResource> list(Long categoryId, String nameKeyword, String urlKeyword, Integer page, Integer size);
}
