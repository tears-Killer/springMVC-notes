package com.chinasoft.dao;

import com.chinasoft.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    //查询所有书籍
    List<Book> getAllBook();

    //查询一本书
    Book getBookById(@Param("id") int id);

    //添加书籍
    int addBook(Book book);

    //修改书籍信息
    int updateBook(Book book);

    //删除书籍
    int deleteBook(@Param("id") int bid);

    List<Book> selectByNameLike(@Param("name") String name);

    List<Book> selectLimit(Map map);

    int bookCount();
}
