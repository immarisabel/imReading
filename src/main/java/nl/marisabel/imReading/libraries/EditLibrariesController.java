package nl.marisabel.imReading.libraries;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EditLibrariesController {

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


    @PostMapping("/new-shelf")
    String addNewShelf(Model model, @ModelAttribute("shelf") LibrariesEntity shelf) {
        librariesService.saveOrUpdate(shelf);
        model.addAttribute("librariesEntity", shelf);
        return "redirect:/books";
    }

    @GetMapping("/updateShelf")
    public String showFormForUpdatingShelf(@RequestParam("id") int id, Model model) {
        LibrariesEntity shelf = librariesService.getShelf(id);
        return "edit-shelves";    }

    @GetMapping("/deleteShelf")
    public String deleteShelf(@RequestParam("id") int id, Model model) {
        librariesService.deleteShelf(id);
        return "edit-shelves";
    }





}
