package com.xqxls.mall.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.xqxls.mall.service.RedisService;
import com.xqxls.mall.mapper.UmsAdminRoleRelationMapper;
import com.xqxls.mall.entity.UmsAdmin;
import com.xqxls.mall.entity.UmsAdminRoleRelation;
import com.xqxls.mall.entity.UmsResource;
import com.xqxls.mall.service.UmsAdminCacheService;
import com.xqxls.mall.service.UmsAdminService;
import com.xqxls.mall.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台用户缓存操作Service实现类
 * Created by xqxls on 2020/3/13.
 */
@Service
public class UmsAdminCacheServiceImpl implements UmsAdminCacheService {

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UmsAdminRoleRelationMapper adminRoleRelationMapper;

    @Value("${redis.database}")
    private String REDIS_DATABASE;

    @Value("${redis.expire.common}")
    private Long REDIS_EXPIRE;

    @Value("${redis.key.admin}")
    private String REDIS_KEY_ADMIN;

    @Value("${redis.key.resourceList}")
    private String REDIS_KEY_RESOURCE_LIST;

    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin admin = adminService.findById(adminId);
        if (admin != null) {
            String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.del(key);
    }

    @Override
    public void delResourceListByRole(Long roleId) {
        Example example = new Example(UmsAdminRoleRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        delRelationList(relationList);
    }

    @Override
    public void delResourceListByRoleIds(List<Long> roleIds) {
        Example example = new Example(UmsAdminRoleRelation.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("roleId", roleIds);
        List<UmsAdminRoleRelation> relationList = adminRoleRelationMapper.selectByExample(example);
        delRelationList(relationList);
    }

    private void delRelationList(List<UmsAdminRoleRelation> relationList) {
        if (CollUtil.isNotEmpty(relationList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> adminIdList = adminRoleRelationMapper.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)) {
            String keyPrefix = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_ADMIN + ":" + admin.getUsername();
        redisService.set(key, admin, REDIS_EXPIRE);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        return ObjectUtil.objectToList(redisService.get(key),UmsResource.class);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = REDIS_DATABASE + ":" + REDIS_KEY_RESOURCE_LIST + ":" + adminId;
        redisService.set(key, resourceList, REDIS_EXPIRE);
    }
}
