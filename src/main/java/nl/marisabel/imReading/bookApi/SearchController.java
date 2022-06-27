package nl.marisabel.imReading.bookApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping(path = "imreading/book")
public class SearchController {

    @Autowired
    SearchBookService searchBookService;

    @GetMapping
    public String searchBook(@RequestParam(required = true) String search, Model model) {

        HashMap<String, String> results = searchBookService.search(search.strip());

        model.addAttribute("results", results);
        model.addAttribute("searchterm", search);

        return "fragments/result";

    }
}
