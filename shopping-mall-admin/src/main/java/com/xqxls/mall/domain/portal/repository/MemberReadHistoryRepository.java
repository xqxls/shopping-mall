package com.xqxls.mall.domain.portal.repository;

import com.xqxls.mall.domain.portal.dto.MemberReadHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xqxls
 * @create 2023-06-20 15:43
 * @Description 会员商品浏览历史Repository
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {

    /**
     * 根据会员ID分页查找记录
     * @param memberId 会员ID
     * @param pageable 分页参数
     * @return 会员商品浏览历史分页信息
     */
    Page<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId, Pageable pageable);

    /**
     * 根据会员ID删除记录
     * @param memberId 会员ID
     */
    void deleteAllByMemberId(Long memberId);
}
