package nl.marisabel.imReading.libraries;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

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

        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "redirect:/shelves";
    }

    @GetMapping("/updateShelf")
    public String showFormForUpdatingShelf(@RequestParam("id") int id, Model model) {
        LibrariesEntity shelf = librariesService.getShelf(id);
        model.addAttribute("shelves", shelf);

        model.addAttribute("name", shelf);
        model.addAttribute("librariesEntity", shelf);

        List<LibrariesEntity> shelves = Collections.singletonList((librariesService.getShelf(shelf.getId())));
        model.addAttribute("shelf", shelves);

        return "edit-shelves";
    }

    @GetMapping("/deleteShelf")
    public String deleteShelf(@RequestParam("id") int id, Model model) {
        librariesService.deleteShelf(id);
        return "redirect:/shelves";
    }

    @RequestMapping("/shelves")
    String editShelves(Model model) {
        List<LibrariesEntity> shelves = librariesService.getShelves();
        model.addAttribute("shelves", shelves);

        //TODO what if there are no shelves yet?
        return "edit-shelves";
    }



}
