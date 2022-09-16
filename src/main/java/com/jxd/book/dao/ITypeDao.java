package com.jxd.book.dao;

import com.jxd.book.model.Type;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITypeDao {
    /**
     * 查找 图书类型表 所有类型
     *
     * @return {@link List}<{@link Type}>
     */
    @Select("select tno, type from btype")
    List<Type> selectAllType();
}
