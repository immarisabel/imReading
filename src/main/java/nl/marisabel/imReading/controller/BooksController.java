package nl.marisabel.imReading.controller;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.repositories.SearchBookRepository;
import nl.marisabel.imReading.services.BooksService;
import nl.marisabel.imReading.services.GetNewBookService;
import nl.marisabel.imReading.services.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/imreading")
@Log4j2
public class BooksController {

    @Autowired
    SearchBookService searchBookService;
    @Autowired
    SearchBookRepository bookRepo;
    @Autowired
    BooksService booksService;
    @Autowired
    GetNewBookService newBookService;

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


    @GetMapping("/addnewbook")
    public String showFormForUpdate(@RequestParam(required = true) String OLid, BooksEntity book, Model model) throws IOException, InterruptedException {

        List<BooksEntity> books = booksService.getBooks();
        model.addAttribute("books", books);

        return "new-book";
    }


    @GetMapping("/searchresults")
    public String searchBook(@RequestParam(required = true) String search, Model model) {
        HashMap<String, String> results = searchBookService.search(search.strip());
        model.addAttribute("results", results);
        model.addAttribute("searchterm", search);
        return "result";
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


}
