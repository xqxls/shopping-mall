package com.xqxls.mall.base;

import com.xqxls.mall.base.provider.SpecialSqlExtProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import java.util.List;

/**
 * @author xqxls
 * @create 2023-06-15 10:17
 * @Description 基础扩展Mapper
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface ExtMapper<T> {
    /**
     * 批量插入全部字段，包括主键
     *
     * @param recordList 数据列表
     * @return 成功插入条数
     */
    @Options(keyProperty = "id")
    @InsertProvider(type = SpecialSqlExtProvider.class, method = "insertBatch")
    int insertBatch(List<? extends T> recordList);

    /**
     * 根据主键批量删除
     *
     * @param recordList 数据列表
     * @return 成功删除条数
     */
    @Options(keyProperty = "id")
    @DeleteProvider(type = SpecialSqlExtProvider.class, method = "deleteByIdList")
    int deleteByIdList(List<Long> recordList);

}
