package com.jxd.book.controller;

import com.jxd.book.model.Type;
import com.jxd.book.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TypeController
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/12
 * @Version 1.0
 */
@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public List<Type> getAllType() {
        List<Type> typeList = typeService.getAllType();
        return typeList;
    }
}
