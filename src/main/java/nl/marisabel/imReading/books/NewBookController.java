package nl.marisabel.imReading.books;

import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.searchApi.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@Log4j2
public class NewBookController {

    @Autowired
    BooksService booksService;
    @Autowired
    AddBookService newBookService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @RequestMapping("/newbook")
    String addNewBookForm(Model model, @ModelAttribute("books") BooksEntity book) throws IOException, InterruptedException {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        return "book-form";
    }

// TODO Cannot invoke "java.util.List.get(int)" because the return value of "nl.marisabel.imReading.searchApi.POJO.BooksInfo.getCovers()" is null


    @RequestMapping("/newbook/{OLid}")
    public String showFormToUpdateBook(@PathVariable(value = "OLid", required = false) String OLid, BooksEntity book, Model model) throws IOException, InterruptedException {
        newBookService.addNewBookFromApi(OLid, book);
        model.addAttribute("books", book);
        return "book-form";
    }


    @PostMapping("/books_saved")
    String saveBook(Model model, @ModelAttribute("book") BooksEntity book) {
        booksService.saveOrUpdate(book);
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);
        return "books";
    }

}
