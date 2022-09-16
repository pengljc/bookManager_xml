package com.jxd.book.controller;

import com.jxd.book.model.Admin;
import com.jxd.book.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/12
 * @Version 1.0
 */
@Controller
//@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private IAdminService adminService;

//    @GetMapping
    @RequestMapping("/book")
    public String verifyLogin(Admin admin) {
        Admin adminRe = adminService.verifyLogin(admin);

        if (adminRe == null) {
            return "login";
        } else {
//            return "http://localhost:8080/bookListPage.jsp";
            return "bookListPage";
        }
    }
}
