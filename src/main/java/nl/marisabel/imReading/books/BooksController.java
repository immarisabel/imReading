package nl.marisabel.imReading.books;

import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.searchApi.AddBookService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@Log4j2
public class BooksController {

    @Autowired
    BooksService booksService;
    @Autowired
    AddBookService newBookService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/newbook")
    String books(Model model, @ModelAttribute("books") BooksEntity book) throws IOException, InterruptedException {

        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);

        return "new-book";
    }


    @RequestMapping("/newbook/{OLid}")
    public String showFormForUpdate(@PathVariable(value = "OLid", required = false) String OLid, BooksEntity book, Model model) throws IOException, InterruptedException {
        newBookService.addNewBookFromApi(OLid, book);
        model.addAttribute("books", book);
        return "new-book";
    }


    @PostMapping("/books_saved")
    String saveBook(Model model, @ModelAttribute("book") BooksEntity book) {
        booksService.saveOrUpdate(book);
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);
        return "books";
    }


    @RequestMapping("/books")
    String post(Model model, @ModelAttribute("book") BooksEntity book) {
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);
        return "books";
    }


    @GetMapping("/delete")
    public String deleteBook(@RequestParam("id") int id) {

        booksService.deleteBook(id);

        return "redirect:/books";

    }

}
