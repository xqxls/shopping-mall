package com.xqxls.mall.service.impl;

import com.google.common.collect.Lists;
import com.xqxls.mall.model.UmsRole;
import com.xqxls.mall.service.UmsRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Description:
 * @Author: huzhuo
 * @Date: Created in 2023/10/2 12:55
 */
@SpringBootTest
public class UmsRoleServiceImplTest {

    @Resource
    private UmsRoleService umsRoleService;

    @Test
    public void create() {
        List<UmsRole> umsRoleList = new ArrayList<>();
        for(int i=1;i<=1000;i++){
            UmsRole role = new UmsRole();
            role.setName("测试角色"+i+3000000);
            role.setCreateTime(new Date());
            role.setAdminCount(0);
            role.setSort(0);
            role.setNumber((long)(i+3+3000000));
            umsRoleList.add(role);
        }
        //按每100个一组分割
        List<List<UmsRole>> parts = Lists.partition(umsRoleList, 1000);
        parts.stream().forEach(list -> {
            umsRoleService.insertList(list);
        });

    }
}