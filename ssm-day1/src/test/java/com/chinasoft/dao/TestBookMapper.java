package com.chinasoft.dao;

import com.chinasoft.pojo.Book;
import com.chinasoft.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookMapper {

    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) app.getBean("bookServiceImpl");
        for (Book book : bookService.getAllBook()) {
            System.out.println(book);
        }
    }
}
