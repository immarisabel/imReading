package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.GenreEntity;
import org.springframework.data.repository.CrudRepository;


public interface GenreRepo extends CrudRepository<GenreEntity, Integer> {
}
