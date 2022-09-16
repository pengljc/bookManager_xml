package com.jxd.book.service.impl;

import com.jxd.book.dao.IBookDao;
import com.jxd.book.model.Book;
import com.jxd.book.service.IBookService;
import com.jxd.book.vo.BookWithTypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/9/2
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookDao bookDao;

    @Override
    public List<BookWithTypeVO> getBookWithType(String bname, String tno, String page, String limit) {
        int pageNum = Integer.parseInt(page);
        int limitNum = Integer.parseInt(limit);
        int tnoNum = -1;
        if (tno != null) {
            tnoNum = Integer.parseInt(tno);
        }

        pageNum = (pageNum - 1) * limitNum;
        List<BookWithTypeVO> list = bookDao.selectBookWithType(bname, tnoNum, pageNum, limitNum);
        return list;
    }

    @Override
    public int getBookNums() {
        int nums = bookDao.selectBookNums();
        return nums;
    }

    @Override
    public Book getBookObjByBno(int bno) {
        Book book = bookDao.selectBookObjByBno(bno);
        return book;
    }

    @Override
    public boolean addOneBook(Book book) {
        boolean isSuccess = bookDao.insertOneBook(book);
        return isSuccess;
    }

    @Override
    public boolean deleteBatchBook(int[] bnos) {
        boolean isSuccess = bookDao.deleteBatchBooks(bnos);
        return isSuccess;
    }

    @Override
    public boolean editOneBook(Book book) {
        boolean isSuccess = bookDao.updateOneBook(book);
        return isSuccess;
    }
}
