package nl.marisabel.imReading.readingLogs;


import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.shelves.ShelvesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/logs")
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

    @GetMapping("/all_logs")
    String displayAllLogs(Model model, @ModelAttribute("log") LogEntity log) {
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "logs";
    }

    @GetMapping("/book/{bookId}")
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
        model.addAttribute("rating", bookId.getRating());
        // BOOK LOGS
        List<LogEntity> list = logsService.byBookId(bookId);
        model.addAttribute("logs", list);
        Set<ShelvesEntity> shelves = bookId.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-logs";
    }




}
