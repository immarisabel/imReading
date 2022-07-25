package nl.marisabel.imReading.books;

import nl.marisabel.imReading.shelves.ShelvesEntity;
import nl.marisabel.imReading.shelves.ShelvesService;
import nl.marisabel.imReading.searchApi.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class EditBooksController {

    @Autowired
    BooksService booksService;
    @Autowired
    AddBookService newBookService;

    @Autowired
    ShelvesService shelvesService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }

    @ModelAttribute("shelvesEntity")
    public ShelvesEntity shelvesEntity() {
        return new ShelvesEntity();
    }


    @RequestMapping("/newbook")
    String addNewBookForm(Model model, @ModelAttribute("books") BooksEntity book) throws IOException, InterruptedException {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);

        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }


    @RequestMapping("/newbook/{OLid}")
    public String showFormToUpdateBook(@PathVariable(value = "OLid", required = false) String OLid, BooksEntity book, Model model) throws IOException, InterruptedException {

        newBookService.addNewBookFromApi(OLid, book);
        model.addAttribute("books", book);

        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }


    @GetMapping("/updateBook")
    public String showBookFormForUpdate(@RequestParam("id") int id, Model model) {

        BooksEntity book = booksService.getBook(id);
        model.addAttribute("booksEntity", book);

        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }


//    CRUD FUNCTIONS

    @PostMapping("/books_saved")
    String saveBook(Model model, @ModelAttribute("book") BooksEntity book, ShelvesEntity shelf) {

        booksService.saveOrUpdate(book);

        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);

        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "books";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        booksService.deleteBook(id);
        return "redirect:/books";
    }


    @ExceptionHandler(value = IllegalStateException.class)
    public String handleIllegalStateExceptionForAuthor(final Model model) {

        String text = "Author information could not be parsed or found. Please select a different book or add it manually.";
        model.addAttribute("error", text);
        return "ExceptionPage";
    }

}
