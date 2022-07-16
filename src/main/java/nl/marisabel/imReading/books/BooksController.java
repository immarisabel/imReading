package nl.marisabel.imReading.books;

import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.libraries.LibrariesEntity;
import nl.marisabel.imReading.libraries.LibrariesService;
import nl.marisabel.imReading.readingLogs.LogEntity;
import nl.marisabel.imReading.searchApi.AddBookService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Controller
@Log4j2
public class BooksController {

    @Autowired
    BooksService booksService;
    @Autowired
    LibrariesService librariesService;


    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/books")
    String post(Model model, @ModelAttribute("book") BooksEntity book) {
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "books";
    }

    @GetMapping("/books/{shelfId}")
    String displayBookLog(@PathVariable("shelfId") LibrariesEntity shelfId, Model model) {

        List<BooksEntity> list = booksService.byShelf(shelfId);
        model.addAttribute("books", list);
        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }

    @GetMapping("/updateBook")
    public String showBookFormForUpdate(@RequestParam("id") int id, Model model) {
        BooksEntity book = booksService.getBook(id);
        log.info(book);
        model.addAttribute("booksEntity", book);
        return "book-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        booksService.deleteBook(id);
        return "redirect:/books";
    }

}
