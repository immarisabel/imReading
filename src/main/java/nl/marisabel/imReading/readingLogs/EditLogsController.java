package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/logs")
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


    @GetMapping("/add")
    String newLogForm(Model model, @ModelAttribute("log") LogEntity log) {
        List<BooksEntity> books = booksService.byStatus("reading");
        model.addAttribute("books", books);
        model.addAttribute("reading", books);
        return "log-form";
    }


    @GetMapping("/add/{id}")
    String newLogFormFromTheBookPage(Model model, @ModelAttribute("log") LogEntity log, @PathVariable(value = "id", required = false) int id ) {
        List<BooksEntity> books = Collections.singletonList(booksService.getBook(id));
        model.addAttribute("books", books);
        model.addAttribute("id", books);
        return "log-form";
    }


    @PostMapping("/save")
    String saveNewLog(Model model, @ModelAttribute("log") LogEntity log) {
        logsService.saveOrUpdate(log);
        List<LogEntity> list = logsService.getLogs();
        model.addAttribute("logs", list);
        return "logs";
    }


    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        LogEntity log = logsService.getLog(id);
        model.addAttribute("bookId", log);
        model.addAttribute("logEntity", log);

        List<BooksEntity> books = Collections.singletonList((booksService.getBook(log.getBookId().getId())));
        model.addAttribute("books", books);
        List<BooksEntity> reading = booksService.byStatus("reading");
        model.addAttribute("reading", reading);
        return "log-form";
    }


    @GetMapping("/delete")
    public String deleteLog(@RequestParam("id") int id, HttpServletRequest request) {
        logsService.deleteLog(id);
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }



}
