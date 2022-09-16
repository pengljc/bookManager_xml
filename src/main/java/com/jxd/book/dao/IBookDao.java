package com.jxd.book.dao;


import com.jxd.book.model.Book;
import com.jxd.book.vo.BookWithTypeVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBookDao {
    /**
     * 选择书类型
     * 1.根据 图书表 + 类型表 得到图书信息，存入vo对象，再封装进list
     * 2.对结果进行分页处理
     * 3.可以根据书名模糊查询图书
     * 4.可以根据类型精确查找图书
     *
     * @param page  页面
     * @param limit 限制
     * @param bname bname
     * @param tno   tno
     * @return {@link List}<{@link BookWithTypeVO}>
     */
    List<BookWithTypeVO> selectBookWithType(@Param("bname") String bname, @Param("tno") int tno,
                                            @Param("page") int page, @Param("limit") int limit);


    /**
     * 查询图书表有多少条记录
     *
     * @return int
     */

    int selectBookNums();


    /**
     * 通过书号，查询出图书对象
     *
     * @param bno bno
     * @return {@link Book}
     */
    Book selectBookObjByBno(int bno);


    /**
     * 插入一本书
     *
     * @param book 书
     * @return boolean
     */
    boolean insertOneBook(Book book);



    /**
     * 更新一个图书信息
     *
     * @param book 书
     * @return boolean
     */
    boolean updateOneBook(Book book);

    /**
     * 批量删除书（一本或多本）
     *
     * @param bnos bno
     * @return boolean
     */
    boolean deleteBatchBooks(@Param("bnos") int[] bnos);
}
