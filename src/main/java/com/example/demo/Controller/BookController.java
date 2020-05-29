package com.example.demo.Controller;

import com.example.demo.Book;
import com.example.demo.BookDao;
import com.fasterxml.jackson.databind.util.JSONPObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping("/findAllBook")
    @ResponseBody
    public List<Book> findAll(){
        return bookDao.findAll();
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        String auth = request.getParameter("auth");
        Integer number = Integer.valueOf(request.getParameter("number"));
        Book book = new Book(name, content, auth, number);
        if(bookDao.findByName(name) != null){
            return "添加的图书已存在！";
        }else{
            bookDao.save(book);
            return "添加成功！";
        }

    }

    @RequestMapping("/findOne")
    @ResponseBody
    public String findOne(HttpServletRequest request){
        String name = request.getParameter("name");
        if(bookDao.findByName(name) == null){
            return "没有此书";
        }else {
            Book book = bookDao.findByName(name);
            return book.toString();
        }

    }

    @RequestMapping("/delOne")
    @ResponseBody
    public String delOne(HttpServletRequest request){
        String name = request.getParameter("name");
        if(bookDao.findByName(name) !=null){
            bookDao.delete(bookDao.findByName(name));
            return "删除成功！";
        }else {
            return "没有此书！";
        }
    }
}
