package nl.marisabel.imReading.controller;

import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/imreading")
public class BooksController {

    @Autowired
    BooksService booksService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/newbook")
    String books(Model model, @ModelAttribute("books") BooksEntity book) {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        return "new-book";
    }

    @RequestMapping("/shelf")
    String post(Model model, @ModelAttribute("book") BooksEntity book) {
        booksService.saveOrUpdate(book);
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);
        return "books";
    }

}
