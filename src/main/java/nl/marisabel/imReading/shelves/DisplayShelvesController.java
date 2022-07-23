package nl.marisabel.imReading.shelves;

import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
public class DisplayShelvesController {

    @Autowired
    BooksService booksService;
    @Autowired
    ShelvesService shelvesService;

    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }

    @ModelAttribute("shelvesEntity")
    public ShelvesEntity shelves() {
        return new ShelvesEntity();
    }

    @RequestMapping("/books")
    String post(Model model, @ModelAttribute("book") BooksEntity book) {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }


    @GetMapping("/books/status/{status}")
    String displayBooksByStatus(@PathVariable("status") String status, Model model) {
        List<BooksEntity> books = booksService.byStatus(status);
        model.addAttribute("books", books);
        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }

    @GetMapping("/books/favorites")
    String displayFavoriteBooks (Model model, BooksEntity book) {
        List<BooksEntity> books = booksService.isFavorite(true);
        model.addAttribute("books", books);
        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }


    @GetMapping("/books/shelf/{shelfId}")
    String displayBookByShelf(@PathVariable("shelfId") int shelfId, Model model) {
        List<BooksEntity> books = booksService.byShelf(shelfId);
        model.addAttribute("books", books);
        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }

    @GetMapping("/books/rating/{rating}")
    String displayBooksByRating(@PathVariable("rating") int rating, Model model) {
        List<BooksEntity> books = booksService.byRating(rating);
        model.addAttribute("books", books);
        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "books";
    }


}
