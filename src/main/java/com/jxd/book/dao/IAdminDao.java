package com.jxd.book.dao;

import com.jxd.book.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IAdminDao {
    /**
     * 从登录的信息，查找管理员账户
     *
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    @Select("select id, name, username, password, grade from admin" +
            " where username = #{username} and password = #{password};")
    Admin selectAdminFromLogin(@Param("username") String username, @Param("password") String password);
}
