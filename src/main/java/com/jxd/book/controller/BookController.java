package com.jxd.book.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jxd.book.model.Admin;
import com.jxd.book.model.Book;
import com.jxd.book.service.IBookService;
import com.jxd.book.vo.BookWithTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/12
 * @Version 1.0
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public Map<String, Object> getBookByPage(String page, String limit, String bname, String type) {
        List<BookWithTypeVO> bookWithTypeList = bookService.getBookWithType(bname, type, page, limit);
        int nums = bookService.getBookNums();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",nums);
        map.put("data",bookWithTypeList);

        return map;
    }

    @PutMapping
    public String addNewBook(@RequestBody Book book) {
        boolean isSuccess = bookService.addOneBook(book);
        return "" + isSuccess;
    }

    @PostMapping
    public String editBook(@RequestBody Book book) {
        boolean isSuccess = bookService.editOneBook(book);
        return "" + isSuccess;
    }

    @DeleteMapping
    public String deleteBookBatch(int[] bnos) {
        boolean isSuccess = bookService.deleteBatchBook(bnos);
        return "" + isSuccess;
    }

}
