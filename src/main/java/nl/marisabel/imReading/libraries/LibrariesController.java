package nl.marisabel.imReading.libraries;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LibrariesController {

    @Autowired
    LibrariesService librariesService;

    @Autowired
    BooksService booksService;

    @RequestMapping("/libraries")
    String getAllLibraries(Model model, @ModelAttribute("shelf") LibrariesEntity library, BooksEntity books){
        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);
        List<BooksEntity> book = booksService.getBooks();
        model.addAttribute("books", book);
        return "fragments/libraries";
    }

//    books lists

    // retrieve list of libraries from LIBRARIES table
    // service


}
