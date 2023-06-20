package com.xqxls.mall.domain.portal.service.impl;

import com.xqxls.mall.annotation.CacheException;
import com.xqxls.mall.domain.portal.entity.UmsMember;
import com.xqxls.mall.domain.portal.service.UmsMemberCacheService;
import com.xqxls.mall.mapper.UmsMemberMapper;
import com.xqxls.mall.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author xqxls
 * @create 2023-06-20 11:01
 * @Description UmsMemberCacheService实现类
 */
@Service
public class UmsMemberCacheServiceImpl implements UmsMemberCacheService {
    
    @Autowired
    private RedisService redisService;
    @Autowired
    private UmsMemberMapper memberMapper;
    
    @Value("${redis.database}")
    private String redisDatabase;
    @Value("${redis.expire.common}")
    private Long redisExpire;
    @Value("${redis.expire.authCode}")
    private Long redisExpireAuthCode;
    @Value("${redis.key.member}")
    private String redisKeyMember;
    @Value("${redis.key.authCode}")
    private String redisKeyAuthCode;

    @Override
    public void delMember(Long memberId) {
        UmsMember umsMember = memberMapper.selectByPrimaryKey(memberId);
        if (umsMember != null) {
            String key = redisDatabase + ":" + redisKeyMember + ":" + umsMember.getUsername();
            redisService.del(key);
        }
    }

    @Override
    public UmsMember getMember(String username) {
        String key = redisDatabase + ":" + redisKeyMember + ":" + username;
        return (UmsMember) redisService.get(key);
    }

    @Override
    public void setMember(UmsMember member) {
        String key = redisDatabase + ":" + redisKeyMember + ":" + member.getUsername();
        redisService.set(key, member, redisExpire);
    }

    @CacheException
    @Override
    public void setAuthCode(String telephone, String authCode) {
        String key = redisDatabase + ":" + redisKeyAuthCode + ":" + telephone;
        redisService.set(key,authCode,redisExpireAuthCode);
    }

    @CacheException
    @Override
    public String getAuthCode(String telephone) {
        String key = redisDatabase + ":" + redisKeyAuthCode + ":" + telephone;
        return (String) redisService.get(key);
    }
}

