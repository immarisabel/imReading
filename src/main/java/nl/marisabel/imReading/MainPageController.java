package nl.marisabel.imReading;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired
    BooksService booksService;

    @RequestMapping("/index")
    String index(Model model) {
        model.addAttribute("reading", statusReading());
       model.addAttribute("read", statusRead().stream().limit(1));
        return "index";
    }
    List<BooksEntity> statusReading() {
        List<BooksEntity> list = booksService.byStatus("reading");
        return list;
    }

    List<BooksEntity> statusRead() {
        List<BooksEntity> list = booksService.byStatus("read");
        return list;
    }

}
