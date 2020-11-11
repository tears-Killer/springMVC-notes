package com.chinasoft.controller;


import com.chinasoft.pojo.Book;
import com.chinasoft.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    int pageSize = 5;
    @RequestMapping(value = "/getAllBook")
    public String getAllBook(HttpSession session, @RequestParam(defaultValue = "1") int pageCount){
        int count = bookService.bookCount();
        int pages = count / pageSize;
        if(count % pageSize != 0){
            pages += 1;
        }
        session.setAttribute("pages",pages);
        int startIndex = (pageCount-1) * pageSize;
        session.setAttribute("pages",pages);
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex",startIndex);
        map.put("pageSize",pageSize);
        List<Book> blist = bookService.selectLimit(map);
        session.setAttribute("blist",blist);
        session.setAttribute("pageCount",pageCount);
        return "redirect: /ssm_day1/index.jsp";
    }

    @RequestMapping(value = "/deleteBook")
    public String deleteBook(int id){
        int res = bookService.deleteBook(id);
        return "redirect: getAllBook";
    }

    @RequestMapping(value = "toAddBook")
    public String toAddBook(){
        return "add";
    }

    @RequestMapping(value = "/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect: getAllBook";
    }

    @RequestMapping(value = "/selectBook")
    public String selectBook(int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "update";
    }

    @RequestMapping(value = "/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect: getAllBook";
    }

    @RequestMapping(value = "/selectByName")
    public String selectByName(String bname,Model model){
        List<Book> blist = bookService.selectByNameLike(bname);
        model.addAttribute("blist",blist);
        return "redirect: /ssm_day1/index.jsp";
    }
}
