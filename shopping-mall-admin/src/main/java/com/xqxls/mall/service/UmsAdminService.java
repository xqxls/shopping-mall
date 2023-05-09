package com.xqxls.mall.service;

import com.xqxls.mall.dto.UmsAdminParam;
import com.xqxls.mall.dto.UpdateAdminPasswordParam;
import com.xqxls.mall.entity.UmsAdmin;
import com.xqxls.mall.entity.UmsResource;
import com.xqxls.mall.entity.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


/**
 * 后台用户表 服务类接口
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
public interface UmsAdminService extends IService<UmsAdmin> {

    UserDetails loadUserByUsername(String username);

    UmsAdmin getAdminByUsername(String username);

    UmsAdminCacheService getCacheService();

    List<UmsResource> getResourceList(Long adminId);

    String login(String username, String password);

    UmsAdmin register(UmsAdminParam umsAdminParam);

    String refreshToken(String token);

    List<UmsRole> getRoleList(Long adminId);

    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    int update(Long id, UmsAdmin admin);

    int updatePassword(UpdateAdminPasswordParam updatePasswordParam);

    int delete(Long id);

    int allocateRole(Long adminId, List<Long> roleIds);
}
