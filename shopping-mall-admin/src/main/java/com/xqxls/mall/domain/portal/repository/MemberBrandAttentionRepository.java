package com.xqxls.mall.domain.portal.repository;

import com.xqxls.mall.domain.portal.dto.MemberBrandAttention;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xqxls
 * @create 2023-06-20 15:17
 * @Description 会员品牌关注Repository
 */
public interface MemberBrandAttentionRepository extends MongoRepository<MemberBrandAttention, String> {
    /**
     * 根据会员ID和品牌ID查找记录
     * @param memberId 会员ID
     * @param brandId 品牌ID
     * @return 会员品牌关注
     */
    MemberBrandAttention findByMemberIdAndBrandId(Long memberId, Long brandId);

    /**
     * 根据会员ID和品牌ID删除记录
     * @param memberId 会员ID
     * @param brandId 品牌ID
     * @return 成功删除条数
     */
    int deleteByMemberIdAndBrandId(Long memberId, Long brandId);

    /**
     * 根据会员ID分页查找记录
     * @param memberId 会员ID
     * @param pageable 分页参数
     * @return 会员品牌关注分页信息
     */
    Page<MemberBrandAttention> findByMemberId(Long memberId, Pageable pageable);

    /**
     * 根据会员ID删除记录
     * @param memberId 会员ID
     */
    void deleteAllByMemberId(Long memberId);
}
