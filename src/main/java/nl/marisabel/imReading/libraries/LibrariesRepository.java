package nl.marisabel.imReading.libraries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrariesRepository extends CrudRepository<LibrariesEntity, Integer> {
}
