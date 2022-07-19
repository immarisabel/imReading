package nl.marisabel.imReading.books;

import nl.marisabel.imReading.libraries.LibrariesEntity;
import nl.marisabel.imReading.libraries.LibrariesService;
import nl.marisabel.imReading.searchApi.AddBookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    LibrariesService librariesService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }
    @ModelAttribute("librariesEntity")
    public LibrariesEntity librariesEntity() {
        return new LibrariesEntity();
    }


    @RequestMapping("/newbook")
    String addNewBookForm(Model model, @ModelAttribute("books") BooksEntity book) throws IOException, InterruptedException {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }

// TODO Cannot invoke "java.util.List.get(int)" because the return value of "nl.marisabel.imReading.searchApi.POJO.BooksInfo.getCovers()" is null


    @RequestMapping("/newbook/{OLid}")
    public String showFormToUpdateBook(@PathVariable(value = "OLid", required = false) String OLid, BooksEntity book, Model model) throws IOException, InterruptedException {
        newBookService.addNewBookFromApi(OLid, book);
        model.addAttribute("books", book);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }


    @PostMapping("/books_saved")
    String saveBook(Model model, @ModelAttribute("book") BooksEntity book) {
        booksService.saveOrUpdate(book);

        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);


        return "books";
    }


    @GetMapping("/updateBook")
    public String showBookFormForUpdate(@RequestParam("id") int id, Model model) {
        BooksEntity book = booksService.getBook(id);
        model.addAttribute("booksEntity", book);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "book-form";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        booksService.deleteBook(id);
        return "redirect:/books";
    }


}
