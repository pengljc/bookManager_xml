package com.jxd.book.service;

import com.jxd.book.model.Type;

import java.util.List;

public interface ITypeService {

    /**
     * 得到 图书类型表 所有类型
     *
     * @return {@link List}<{@link Type}>
     */
    List<Type> getAllType();
}
