package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.entity.UmsMember;
import com.xqxls.mall.service.IService;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 会员表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @param telephone 手机号
     * @param authCode 验证码
     */
    void register(String username, String password, String telephone, String authCode);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 获取当前登录会员
     * @return 当前登录会员
     */
    UmsMember getCurrentMember();

    /**
     * 生成验证码
     * @param telephone 手机号
     * @return 验证码
     */
    String generateAuthCode(String telephone);

    /**
     * 修改密码
     * @param telephone 手机号
     * @param password 密码
     * @param authCode 验证码
     */
    void updatePassword(String telephone, String password, String authCode);

    /**
     * 刷新token
     * @param token 老的token
     * @return 刷新之后的token
     */
    String refreshToken(String token);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取会员
     * @param username 用户名
     * @return 会员信息
     */
    UmsMember getByUsername(String username);

    /**
     * 根据会员id修改会员积分
     * @param id 会员ID
     * @param integration 积分
     */
    void updateIntegration(Long id,Integer integration);

    /**
     * 根据会员编号获取会员
     * @param memberId 会员ID
     * @return 会员信息
     */
    UmsMember getById(Long memberId);
}
