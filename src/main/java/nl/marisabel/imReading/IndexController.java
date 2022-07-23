package nl.marisabel.imReading;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexController {

    @Autowired
    BooksService booksService;

    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("reading", statusReading());
        model.addAttribute("read", statusRead());
        return "index";
    }

    @RequestMapping("/test")
    String test(){
        return "teststar";
    }

    List<BooksEntity> statusReading() {
        return booksService.byStatus("reading");
    }

    List<BooksEntity> statusRead() {
        return booksService.byStatus("read").stream().limit(5).collect(Collectors.toList());
    }

}
