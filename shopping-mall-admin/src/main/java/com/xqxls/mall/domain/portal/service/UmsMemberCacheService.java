package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.entity.UmsMember;

/**
 * @author xqxls
 * @create 2023-06-20 10:57
 * @Description 会员信息缓存业务类
 */
public interface UmsMemberCacheService {

    /**
     * 删除会员用户缓存
     * @param memberId 会员用户ID
     */
    void delMember(Long memberId);

    /**
     * 获取会员用户缓存
     * @param username 会员用户名
     * @return 会员用户
     */
    UmsMember getMember(String username);

    /**
     * 设置会员用户缓存
     * @param member 会员实体
     */
    void setMember(UmsMember member);

    /**
     * 设置验证码
     * @param telephone 手机号
     * @param authCode 验证码
     */
    void setAuthCode(String telephone, String authCode);

    /**
     * 获取验证码
     * @param telephone 手机号
     * @return 验证码
     */
    String getAuthCode(String telephone);
}
