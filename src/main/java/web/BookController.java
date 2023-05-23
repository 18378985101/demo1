package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class BookController {
    // http://127.0.0.1:8080/Bookname?name=《三国演义》
    @RequestMapping("/Bookname")
    @ResponseBody
    public String books(@RequestParam(name = "name", defaultValue = "unknown user") String bookname) {
        return "bookname: " + bookname;
    }
    // http://127.0.0.1:8080/Book
    @RequestMapping("/Book")
    @ResponseBody
    public Book book() {
        Book book = new Book();
        book.setBookname("《红楼梦》");
        book.setPrice(100);
        return book;
    }
    // http://127.0.0.1:8080/save_Book?bookname=newName&price=110
    @RequestMapping("/save_Book")
    @ResponseBody
    public String saveBook(Book b) {
        return "book will save: bookname=" + b.getBookname() + ", price=" + b.getPrice();
    }
    // http://127.0.0.1:8080/html
    @RequestMapping("/html")
    public String html(){
        return "index.html";
    }
    @ModelAttribute
    public void parseUser(@RequestParam(name = "bookname", defaultValue = "unknown Book") String bookname
            , @RequestParam(name = "price", defaultValue = "12") Integer price, Book book) {
        book.setBookname("《水浒传》");
        book.setPrice(160);
    }

}
