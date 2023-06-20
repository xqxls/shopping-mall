package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.dto.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * @author xqxls
 * @create 2023-06-20 15:26
 * @Description 会员商品收藏管理Service
 */
public interface MemberCollectionService {

    /**
     * 添加收藏
     * @param productCollection 会员商品收藏
     * @return 成功添加条数
     */
    int add(MemberProductCollection productCollection);

    /**
     * 删除收藏
     * @param productId 商品ID
     * @return 成功删除条数
     */
    int delete(Long productId);

    /**
     * 分页查询收藏
     * @param pageNum 当前页
     * @param pageSize 每一页记录数
     * @return 会员商品收藏分页信息
     */
    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    /**
     * 查看收藏详情
     * @param productId 商品ID
     * @return 收藏详情
     */
    MemberProductCollection detail(Long productId);

    /**
     * 清空收藏
     */
    void clear();
}
