package nl.marisabel.imReading.bookApi;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "book/{id}")
public class ResultBooksController {

    @Autowired
    SearchBookService searchBookService;

    @Autowired
    BooksService booksService;

    @Autowired
    SearchBookRepository bookRepo;


    @ModelAttribute("booksEntity")
    public BooksEntity books() {
        return new BooksEntity();
    }


    @GetMapping
    public String resultPage(@RequestParam("id") @PathVariable(name = "id", required = true) String id, @ModelAttribute("books") BooksEntity book, Model model) {
        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);
        try {
            String jsonStringBookInfo = searchBookService.getBookDetail(id);
            BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
            String title = bookJson.getTitle();

            String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
            String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);
            AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
            String author = authorJson.getName();

            String cover = String.valueOf(bookJson.getCovers().get(0));

            boolean cached = false;

            String coverUrl="https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";

            model.addAttribute("title", title);
            model.addAttribute("author", author);
            model.addAttribute("thumbnailUrl", coverUrl);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return "new-book";
    }
}