package com.xqxls.mall.domain.portal.repository;

import com.xqxls.mall.domain.portal.dto.MemberProductCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author xqxls
 * @create 2023-06-20 15:31
 * @Description 会员商品收藏Repository
 */
public interface MemberProductCollectionRepository extends MongoRepository<MemberProductCollection, String> {
    /**
     * 根据会员ID和商品ID查找记录
     * @param memberId 会员ID
     * @param productId 商品ID
     * @return 会员商品收藏
     */
    MemberProductCollection findByMemberIdAndProductId(Long memberId, Long productId);

    /**
     * 根据会员ID和商品ID删除记录
     * @param memberId 会员ID
     * @param productId 商品ID
     * @return 成功删除条数
     */
    int deleteByMemberIdAndProductId(Long memberId, Long productId);

    /**
     * 根据会员ID分页查询记录
     * @param memberId 会员ID
     * @param pageable 分页参数
     * @return 会员商品收藏分页信息
     */
    Page<MemberProductCollection> findByMemberId(Long memberId, Pageable pageable);

    /**
     * 根据会员ID删除录
     * @param memberId 会员ID
     */
    void deleteAllByMemberId(Long memberId);
}
