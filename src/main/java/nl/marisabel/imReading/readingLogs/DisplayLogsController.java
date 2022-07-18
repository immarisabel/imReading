package nl.marisabel.imReading.readingLogs;


import nl.marisabel.imReading.books.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DisplayLogsController {

    @Autowired
    LogsService logsService;

    @ModelAttribute("logEntity")
    public LogEntity logForm() {
        return new LogEntity();
    }

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
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
        model.addAttribute("favorite", bookId.isFavorite());
        model.addAttribute("id", bookId.getId());
        // BOOK LOGS
        List<LogEntity> list = logsService.byBookId(bookId);
        model.addAttribute("logs", list);

        return "book-logs";
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
