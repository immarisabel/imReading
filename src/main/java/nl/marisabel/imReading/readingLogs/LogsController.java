package nl.marisabel.imReading.readingLogs;


import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class LogsController {

    @Autowired
    LogsService logsService;
    @Autowired
    BooksService booksService;
    @ModelAttribute("logEntity")
    public LogEntity logForm() {
        return new LogEntity();
    }

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }





    @GetMapping("/log")
    String newLogForm(Model model, @ModelAttribute("log") LogEntity log) {
        List<BooksEntity> books = booksService.byStatus("reading");
        model.addAttribute("books", books);
        model.addAttribute("reading", books);
        return "new-log";
    }

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

    @GetMapping("/logs/{bookId}")
    String displayBookLog(@PathVariable("bookId") BooksEntity bookId, Model model) {
        // BOOK INFO
        model.addAttribute("title", bookId.getTitle());
        model.addAttribute("author", bookId.getAuthor());
        model.addAttribute("cover", bookId.getThumbnailUrl());
        model.addAttribute("status", bookId.getStatus());
        model.addAttribute("started", bookId.getStartDate());
        model.addAttribute("finished", bookId.getFinishedDate());
        // BOOK LOGS
        List<LogEntity> list = logsService.byBookId(bookId);
        model.addAttribute("logs", list);

        return "book-logs";
    }


    @GetMapping("/updateLog")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        LogEntity log = logsService.getLog(id);
        model.addAttribute("bookId", log);
        model.addAttribute("logEntity", log);

        List<BooksEntity> books = Collections.singletonList((booksService.getBook(log.getBookId().getId())));
        model.addAttribute("books", books);
        List<BooksEntity> reading = booksService.byStatus("reading");
        model.addAttribute("reading", reading);
        return "new-log";
    }

    @PostMapping("/update-log")
    String updateLog(Model model, @ModelAttribute("log") LogEntity log, @RequestParam("id") int id) {
        logsService.saveOrUpdate(log);
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "logs";
    }


    @GetMapping("/deleteLog")
    public String deleteLog(@RequestParam("id") int id, HttpServletRequest request) {
        logsService.deleteLog(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }


    // Book registry
    //TODO study wtf this is :D ...
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }



}
