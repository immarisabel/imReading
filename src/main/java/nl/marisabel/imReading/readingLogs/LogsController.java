package nl.marisabel.imReading.readingLogs;


import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.List;

@Controller
public class LogsController {

    @Autowired
    LogsService logsService;

    @ModelAttribute("logEntity")
    public LogEntity logForm() {
        return new LogEntity();
    }

    @Autowired
    BooksService booksService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }


    @GetMapping("/log")
    String newLogForm(Model model, @ModelAttribute("log") LogEntity log) {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        return "new-log";
    }

    //TODO fix to display only the added log inside the chosen book, not ALL
    @PostMapping("/new-log")
    String saveNewLog(Model model, @ModelAttribute("log") LogEntity log) {
        logsService.saveOrUpdate(log);
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "logs";
    }

    @GetMapping("/logs")
    String displayAllLogs(Model model, @ModelAttribute("log") LogEntity log) {
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "logs";
    }


    @GetMapping("/logs/{OLid}")
    String displayBookLog(Model model, @ModelAttribute("log") LogEntity log) {

        return "booklog";
    }


    // Book registry
    //TODO study wtf this is :D ...
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }


}
