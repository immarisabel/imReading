package nl.marisabel.imReading.controller;

import nl.marisabel.imReading.dto.LogDto;
import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.services.Books;
import nl.marisabel.imReading.services.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/imreading")
public class LogController {

    @Autowired
    Books books;
    @Autowired
    Logs logs;

    @ModelAttribute("logDto")
    public LogDto logForm() {
        return new LogDto();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

    @RequestMapping("/index")
    String index(Model model) {

        return "index";
    }

    @RequestMapping("/new-log")
    String post(Model model,@ModelAttribute("log") LogEntity log ) {
        return "temp";
    }

    @RequestMapping("/log")
    String log(Model model, @ModelAttribute("log") LogEntity log) {
        List<String> books = Arrays.asList("Harry Potter", "Touch", "My life");
        model.addAttribute("booksList", books);
        logs.saveOrUpdate(log);
        return "new-log";
    }

    @GetMapping("/books")
    private List<BooksEntity> getAllReadBooks() {
        return books.getReadBooks();
    }

    @GetMapping("/books/{isbn}")
    private BooksEntity getBook(@PathVariable("isbn") String isbn) {
        return books.getBookbyIsbn(isbn);
    }

    @DeleteMapping("/books/{isbn}")
    private void deleteBook(@PathVariable("isbn") String isbn) {
        books.delete(isbn);
    }

    @PostMapping("/books")
    private String saveBook(@RequestBody BooksEntity newBook) {
        books.saveOrUpdate(newBook);
        return newBook.getIsbn();
    }


}
