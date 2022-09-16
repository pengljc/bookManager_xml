package com.jxd.book.service;

import com.jxd.book.model.Admin;

public interface IAdminService {
    /**
     * 验证登录
     *
     * @param admin 管理
     * @return boolean
     */
    Admin verifyLogin(Admin admin);


}
