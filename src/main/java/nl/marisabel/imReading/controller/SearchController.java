package nl.marisabel.imReading.controller;

import java.util.HashMap;

import nl.marisabel.imReading.services.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/imreading/book")
public class SearchController {

    @Autowired
    SearchBookService bookService;

    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String searchBook(@RequestParam(required = true) String search, Model model) {

        HashMap<String, String> results = bookService.search(search.strip());

        model.addAttribute("results", results);
        model.addAttribute("searchterm", search);

        return "result";
    }
}

