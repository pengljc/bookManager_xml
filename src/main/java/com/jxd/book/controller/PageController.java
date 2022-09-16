package com.jxd.book.controller;

import com.jxd.book.model.Book;
import com.jxd.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/13
 * @Version 1.0
 */
@Controller
@RequestMapping("/pages")
public class PageController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/add")
    public String toAddPage() {
        return "addBook";
    }

    @GetMapping("/{bno}")
    public String toEditPage(@PathVariable int bno, Model model) {
        Book book = bookService.getBookObjByBno(bno);
        model.addAttribute("book",book);
        return "editBook";
    }
}
