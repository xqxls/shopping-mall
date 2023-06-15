package com.xqxls.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.xqxls.mall.dto.UmsMenuNode;
import com.xqxls.mall.entity.UmsMenu;
import com.xqxls.mall.service.UmsMenuService;
import com.xqxls.mall.mapper.UmsMenuMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 后台菜单表 服务实现类
 *
 * @author xqxls
 * @date 2023-05-09 11:14 上午
 */
@Service
public class UmsMenuServiceImpl extends ServiceImpl<UmsMenuMapper, UmsMenu> implements UmsMenuService {

    @Autowired
    private UmsMenuMapper umsMenuMapper;

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        updateLevel(umsMenu);
        return this.add(umsMenu);
    }

    /**
     * 修改菜单层级
     */
    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0) {
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        } else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = this.findById(umsMenu.getParentId());
            if (parentMenu != null) {
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            } else {
                umsMenu.setLevel(0);
            }
        }
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        umsMenu.setId(id);
        updateLevel(umsMenu);
        return this.update(umsMenu);
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        Example example = new Example(UmsMenu.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId", parentId);
        example.orderBy("sort").desc();
        return umsMenuMapper.selectByExample(example);
    }

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = this.findAll();
        return menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        UmsMenu umsMenu = new UmsMenu();
        umsMenu.setId(id);
        umsMenu.setHidden(hidden);
        return this.update(umsMenu);
    }

    /**
     * 将UmsMenu转化为UmsMenuNode并设置children属性
     * @param menu 菜单
     * @param menuList 整个菜单列表
     * @return 菜单节点
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode node = new UmsMenuNode();
        BeanUtils.copyProperties(menu,node);
        List<UmsMenuNode> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;

    }
}
