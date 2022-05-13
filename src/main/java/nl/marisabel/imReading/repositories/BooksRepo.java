package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BooksRepo extends CrudRepository<BooksEntity, String> {
}
