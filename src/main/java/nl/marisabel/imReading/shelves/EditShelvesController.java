package nl.marisabel.imReading.shelves;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/shelves")
public class EditShelvesController {

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


    @PostMapping("/add")
    String addNewShelf(Model model, @ModelAttribute("shelf") ShelvesEntity shelf) {
        shelvesService.saveOrUpdate(shelf);
        model.addAttribute("shelvesEntity", shelf);

        List<ShelvesEntity> shelves = shelvesService.getShelves();
        model.addAttribute("shelves", shelves);
        return "redirect:/shelves/manage";
    }

    @GetMapping("/update")
    public String showFormForUpdatingShelf(@RequestParam("id") int id, Model model) {
        ShelvesEntity shelf = shelvesService.getShelf(id);
        List<ShelvesEntity> shelves = Collections.singletonList((shelvesService.getShelf(shelf.getId())));

        model.addAttribute("shelves", shelf);
        model.addAttribute("name", shelf);
        model.addAttribute("shelvesEntity", shelf);
        model.addAttribute("shelf", shelves);

        return "edit-shelves";
    }

    @GetMapping("/delete")
    public String deleteShelf(@RequestParam("id") int id, Model model, BooksEntity books) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> SHELF ID: " +id + "DELETED");
        shelvesService.deleteShelf(id);
        return "redirect:/shelves/manage";
    }




}
