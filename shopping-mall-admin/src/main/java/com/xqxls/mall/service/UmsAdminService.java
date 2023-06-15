package com.xqxls.mall.service;

import com.xqxls.mall.dto.UmsAdminParam;
import com.xqxls.mall.dto.UpdateAdminPasswordParam;
import com.xqxls.mall.entity.UmsAdmin;
import com.xqxls.mall.entity.UmsResource;
import com.xqxls.mall.entity.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 后台用户表 服务类接口
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    /**
     * 通过用户名查找用户登录凭证
     * @param username 用户名
     * @return 用户登录凭证
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 通过用户名查找用户信息
     * @param username 用户名
     * @return 用户信息
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取缓存服务
     * @return 缓存服务
     */
    UmsAdminCacheService getCacheService();

    /**
     * 通过用户获取资源列表
     * @param adminId 用户ID
     * @return 资源列表
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return token
     */
    String login(String username, String password);

    /**
     * 注册
     * @param umsAdminParam 注册参数
     * @return 用户信息
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 刷新token
     * @param token 旧的token
     * @return 刷新后的token
     */
    String refreshToken(String token);

    /**
     * 通过用户获取角色列表
     * @param adminId 用户ID
     * @return 角色列表
     */
    List<UmsRole> getRoleList(Long adminId);

    /**
     * 查询用户分页信息
     * @param keyword 搜索关键词
     * @param pageSize 每一页记录数
     * @param pageNum 当前页
     * @return 用户分页信息
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 更新用户
     * @param id 用户ID
     * @param admin 用户
     * @return 成功更新条数
     */
    int update(Long id, UmsAdmin admin);

    /**
     * 更新密码
     * @param updatePasswordParam 更新密码参数
     * @return 成功更新条数
     */
    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    /**
     * 删除用户
     * @param id 用户ID
     * @return 成功删除条数
     */
    int delete(Long id);

    /**
     * 给用户分配角色
     * @param adminId 用户ID
     * @param roleIds 角色ID列表
     * @return 成功分配角色数量
     */
    int allocateRole(Long adminId, List<Long> roleIds);
}
