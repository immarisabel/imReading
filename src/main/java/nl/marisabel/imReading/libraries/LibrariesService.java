package nl.marisabel.imReading.libraries;


import nl.marisabel.imReading.readingLogs.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibrariesService {

    @Autowired
    LibrariesRepository librariesRepository;

    public List<LibrariesEntity> getShelves(){
        List<LibrariesEntity> shelves = new ArrayList<>();
        librariesRepository.findAll().forEach(shelves::add);
        return shelves;
    }

    LibrariesEntity getShelf(int id){
        return librariesRepository.findById(id).get();
    }

    public void saveOrUpdate(LibrariesEntity shelf) {
        librariesRepository.save(shelf);
    }

    // TODO make sure this deleting requires full verification with TEXT, shelf gone = all books gone!
    public void deleteShelf(int id) {
        librariesRepository.deleteById(id);
    }

}
