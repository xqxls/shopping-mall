package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.dto.MemberBrandAttention;
import org.springframework.data.domain.Page;

/**
 * @author xqxls
 * @create 2023-06-20 15:13
 * @Description 会员品牌关注管理Service
 */
public interface MemberAttentionService {

    /**
     * 添加关注
     * @param memberBrandAttention 会员品牌关注
     * @return 成功添加条数
     */
    int add(MemberBrandAttention memberBrandAttention);

    /**
     * 取消关注
     * @param brandId 品牌ID
     * @return 成功删除条数
     */
    int delete(Long brandId);

    /**
     * 获取用户关注列表
     * @param pageNum 当前页
     * @param pageSize 每一页记录数
     * @return 用户关注列表分页信息
     */
    Page<MemberBrandAttention> list(Integer pageNum, Integer pageSize);

    /**
     * 获取用户关注详情
     * @param brandId 品牌ID
     * @return 用户关注详情
     */
    MemberBrandAttention detail(Long brandId);

    /**
     * 清空关注列表
     */
    void clear();
}
