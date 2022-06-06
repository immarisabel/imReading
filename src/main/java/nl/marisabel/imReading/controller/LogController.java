package nl.marisabel.imReading.controller;


import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.services.BooksService;
import nl.marisabel.imReading.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/imreading")
public class LogController {

    @Autowired
    LogsService logsService;

    @Autowired
    BooksService booksService;

    @ModelAttribute("logEntity")
    public LogEntity logForm() {
        return new LogEntity();
    }
    @ModelAttribute("books")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }

    @GetMapping("/log")
    String log(Model model, @ModelAttribute("log") LogEntity log) {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        return "new-log";
    }

    @PostMapping("/new-log")
    String post(Model model,  @ModelAttribute("log") LogEntity log) {
        logsService.saveOrUpdate(log);



        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "temp";
    }


    @GetMapping("/test")
    String test(Model model,  @ModelAttribute("book") BooksEntity books) {

        List<BooksEntity> list = booksService.getBooks();
        System.out.println(list);
        model.addAttribute("books", list);

        return "test";
    }


    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }





}
