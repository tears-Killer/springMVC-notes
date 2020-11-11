package com.chinasoft.service;

import com.chinasoft.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookService {
    //查询所有书籍
    List<Book> getAllBook();

    //查询一本书
    Book getBookById(int id);

    //添加书籍
    int addBook(Book book);

    //修改书籍信息
    int updateBook(Book book);

    //删除书籍
    int deleteBook(int bid);

    List<Book> selectByNameLike(String name);

    List<Book> selectLimit(Map map);

    int bookCount();
}
