package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class EditLogsController {

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

//    @PostMapping("/update-log")
//    String updateLog(Model model, @ModelAttribute("log") LogEntity log, @RequestParam("id") int id) {
//        logsService.saveOrUpdate(log);
//        List<LogEntity> list = logsService.getLogs();
//        model.addAttribute("logs", list);
//        return "logs";
//    }
}