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
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 后台用户缓存操作Service实现类
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
    private String redisDatabase;

    @Value("${redis.expire.common}")
    private Long redisExpire;

    @Value("${redis.key.admin}")
    private String redisKeyAdmin;

    @Value("${redis.key.resourceList}")
    private String redisKeyResourceList;

    @Override
    public void delAdmin(Long adminId) {
        UmsAdmin admin = adminService.findById(adminId);
        if (admin != null) {
            String key = redisDatabase + ":" + redisKeyAdmin + ":" + admin.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public void delResourceList(Long adminId) {
        String key = redisDatabase + ":" + redisKeyResourceList + ":" + adminId;
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
            String keyPrefix = redisDatabase + ":" + redisKeyResourceList + ":";
            List<String> keys = relationList.stream().map(relation -> keyPrefix + relation.getAdminId()).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public void delResourceListByResource(Long resourceId) {
        List<Long> adminIdList = adminRoleRelationMapper.getAdminIdList(resourceId);
        if (CollUtil.isNotEmpty(adminIdList)) {
            String keyPrefix = redisDatabase + ":" + redisKeyResourceList + ":";
            List<String> keys = adminIdList.stream().map(adminId -> keyPrefix + adminId).collect(Collectors.toList());
            redisService.del(keys);
        }
    }

    @Override
    public UmsAdmin getAdmin(String username) {
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + username;
        return (UmsAdmin) redisService.get(key);
    }

    @Override
    public void setAdmin(UmsAdmin admin) {
        String key = redisDatabase + ":" + redisKeyAdmin + ":" + admin.getUsername();
        redisService.set(key, admin, redisExpire);
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        String key = redisDatabase + ":" + redisKeyResourceList + ":" + adminId;
        return ObjectUtil.objectToList(redisService.get(key),UmsResource.class);
    }

    @Override
    public void setResourceList(Long adminId, List<UmsResource> resourceList) {
        String key = redisDatabase + ":" + redisKeyResourceList + ":" + adminId;
        redisService.set(key, resourceList, redisExpire);
    }
}
