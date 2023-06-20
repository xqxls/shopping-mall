package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.dto.MemberReadHistory;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-20 15:40
 * @Description 会员浏览记录管理Service
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     * @param memberReadHistory 浏览记录
     * @return 成功添加条数
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids 浏览记录ID列表
     * @return 成功删除条数
     */
    int delete(List<String> ids);

    /**
     * 分页获取用户浏览历史记录
     * @param pageNum 当前页
     * @param pageSize 每一页记录数
     * @return 浏览历史记录分页信息
     */
    Page<MemberReadHistory> list(Integer pageNum, Integer pageSize);

    /**
     * 清空浏览记录
     */
    void clear();
}
