package com.jxd.book.service;

import com.jxd.book.model.Book;
import com.jxd.book.vo.BookWithTypeVO;

import java.util.List;

public interface IBookService {
    /**
     * 让书型
     * 1.根据 图书表 + 类型表 得到图书信息，存入vo对象，再封装进list
     * 2.对结果进行分页处理
     * 3.可以根据书名模糊查询图书
     * 4.可以根据类型精确查找图书
     *
     * @param page  页面
     * @param limit 限制
     * @param bname 书名
     * @param tno   类型号
     * @return {@link List}<{@link BookWithTypeVO}>
     */
    List<BookWithTypeVO> getBookWithType(String bname, String tno, String page, String limit);

    /**
     * 查找图书表有多少本书
     *
     * @return int
     */
    int getBookNums();

    /**
     *通过书号查找图书对象
     *
     * @param bno bno
     * @return {@link Book}
     */
    Book getBookObjByBno(int bno);

    /**
     * 插入一本书
     *
     * @param book 书
     * @return boolean
     */
    boolean addOneBook(com.jxd.book.model.Book book);

    /**
     * 删除书
     *
     * @param bnos bno
     * @return boolean
     */
    boolean deleteBatchBook(int[] bnos);

    /**
     * 编辑图书信息
     *
     * @param book 书
     * @return boolean
     */
    boolean editOneBook(Book book);
}
