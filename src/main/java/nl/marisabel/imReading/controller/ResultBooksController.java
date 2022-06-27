package nl.marisabel.imReading.controller;


import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.repositories.SearchBookRepository;
import nl.marisabel.imReading.services.BooksService;
import nl.marisabel.imReading.services.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(path = "book/{id}")
@Log4j2
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
    public String resultPage(final HttpSession session,
                             final HttpServletRequest request,
                             @RequestParam(value = "bookId", required = false)
                             @PathVariable(name = "bookId", required = true) String bookId,
                             @ModelAttribute("books") BooksEntity book, Model model) {


        //TODO ID is not parsing to parameter
        bookId = "OL20796936W";


        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);


        try {
            String jsonStringBookInfo = searchBookService.getBookDetail(bookId);
            BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
            String title = bookJson.getTitle();
            String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
            String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);
            AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
            String author = authorJson.getName();
            String cover = String.valueOf(bookJson.getCovers().get(0));

            boolean cached = false;

            String coverUrl = "https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";

            log.info(">>>>>>>>>>>>>>> ID: " + bookId);
            log.info(">>>>>>>>>>>>>>> author: " + author);
            log.info(">>>>>>>>>>>>>>> title: " + title);
            log.info(">>>>>>>>>>>>>>> title: " + coverUrl);
            book.setAuthor(author);
            book.setTitle(title);
            book.setThumbnailUrl(coverUrl);

            model.addAttribute("booksEntity", book);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "new-book";
    }
}