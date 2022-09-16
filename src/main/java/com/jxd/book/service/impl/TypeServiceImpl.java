package com.jxd.book.service.impl;

import com.jxd.book.dao.ITypeDao;
import com.jxd.book.model.Type;
import com.jxd.book.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookTypeServiceImpl
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/2
 * @Version 1.0
 */
@Service
public class TypeServiceImpl implements ITypeService {
    @Autowired
    private ITypeDao typeDao;

    @Override
    public List<Type> getAllType() {
        List<Type> list = typeDao.selectAllType();
        return list;
    }
}
