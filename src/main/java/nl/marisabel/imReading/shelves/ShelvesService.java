package nl.marisabel.imReading.shelves;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShelvesService {

    @Autowired
    ShelvesRepository shelvesRepository;

    public List<ShelvesEntity> getShelves(){
        List<ShelvesEntity> shelves = new ArrayList<>();
        shelvesRepository.findAll().forEach(shelves::add);
        return shelves;
    }

    ShelvesEntity getShelf(int id){
        return shelvesRepository.findById(id).get();
    }

    public void saveOrUpdate(ShelvesEntity shelf) {
        shelvesRepository.save(shelf);
    }

    // TODO make sure this deleting requires full verification with TEXT, shelf gone = all books gone!
    public void deleteShelf(int id) {
        shelvesRepository.deleteById(id);
    }

}
