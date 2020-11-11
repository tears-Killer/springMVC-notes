package com.chinasoft.service;

import com.chinasoft.dao.BookMapper;
import com.chinasoft.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

    @Override
    public Book getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBook(int bid) {
        return bookMapper.deleteBook(bid);
    }

    @Override
    public List<Book> selectByNameLike(String name) {
        return bookMapper.selectByNameLike(name);
    }

    @Override
    public List<Book> selectLimit(Map map) {
        return bookMapper.selectLimit(map);
    }

    @Override
    public int bookCount() {
        return bookMapper.bookCount();
    }
}
