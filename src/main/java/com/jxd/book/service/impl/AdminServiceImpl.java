package com.jxd.book.service.impl;

import com.jxd.book.dao.IAdminDao;
import com.jxd.book.model.Admin;
import com.jxd.book.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/8/31
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDao adminDao;
    @Override
    public Admin verifyLogin(Admin admin) {
        String username = admin.getUsername();
        String password = admin.getPassword();

        Admin adminRe = adminDao.selectAdminFromLogin(username,password);

        return adminRe;
    }
}
