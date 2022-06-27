package nl.marisabel.imReading.bookApi;


import java.io.IOException;
import java.util.logging.Logger;

import com.google.gson.Gson;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "imreading/book/{id}")
public class ResultBooksController {

    @Autowired
    SearchBookService searchBookService;

    @Autowired
    SearchBookRepository bookRepo;

    Logger logger = Logger.getLogger(ResultBooksController.class.getName());

    @GetMapping
    public String resultpage(@PathVariable(name = "id", required = true) String id, Model model) {

        try {
            String jsonStringBookInfo = searchBookService.getBookDetail(id);
            BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
            String title = bookJson.getTitle();

            boolean cached = false;
            model.addAttribute("title", title);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


//            model.addAttribute("title", bookDetail.get("title"));
//            model.addAttribute("Description", bookDetail.get("description"));
//            model.addAttribute("excerpt", bookDetail.get("excerpt"));
//            model.addAttribute("cache", cached? "Yes":"no");


        return "detail";
    }
}