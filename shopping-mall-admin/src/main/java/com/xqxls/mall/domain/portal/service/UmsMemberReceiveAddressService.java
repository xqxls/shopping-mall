package com.xqxls.mall.domain.portal.service;

import com.xqxls.mall.domain.portal.entity.UmsMemberReceiveAddress;
import com.xqxls.mall.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会员收货地址表 服务类接口
 *
 * @author xqxls
 * @date 2023-06-20 9:49 上午
 */
public interface UmsMemberReceiveAddressService extends IService<UmsMemberReceiveAddress> {

    /**
     * 添加收货地址
     * @param address 收货地址
     * @return 成功添加条数
     */
    int create(UmsMemberReceiveAddress address);

    /**
     * 删除收货地址
     * @param id 地址表的id
     * @return 成功删除条数
     */
    int delete(Long id);

    /**
     * 修改收货地址
     * @param id 地址表的id
     * @param address 修改的收货地址信息
     * @return 成功修改条数
     */
    int update(Long id, UmsMemberReceiveAddress address);

    /**
     * 返回当前用户的收货地址
     * @return 当前用户的收货地址列表
     */
    List<UmsMemberReceiveAddress> list();

    /**
     * 获取地址详情
     * @param id 地址id
     * @return 地址详情
     */
    UmsMemberReceiveAddress getItem(Long id);
}
