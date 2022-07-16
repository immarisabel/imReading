package nl.marisabel.imReading.libraries;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DisplayLibrariesController {

    @Autowired
    BooksService booksService;
    @Autowired
    LibrariesService librariesService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }

    @ModelAttribute("librariesEntity")
    public LibrariesEntity shelves() {
        return new LibrariesEntity();
    }

    @RequestMapping("/books")
    String post(Model model, @ModelAttribute("book") BooksEntity book) {
        List<BooksEntity> list = booksService.getBooks();
        model.addAttribute("books", list);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        return "books";
    }


    @GetMapping("/books/status/{status}")
    String displayBooksByStatus(@PathVariable("status") String status, Model model) {

        List<BooksEntity> list = booksService.byStatus(status);
        model.addAttribute("books", list);

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }

    @GetMapping("/books/favorites")
    String displayFavoriteBooks (Model model, BooksEntity book) {
        System.out.println(book.isFavorite());
        List<BooksEntity> list = booksService.isFavorite(true);
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

    @RequestMapping("/shelves")
    String editShelves(Model model) {
        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "edit-shelves";
    }
}
