package nl.marisabel.imReading.books;

import nl.marisabel.imReading.readingLogs.LogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntity, Integer> {

    List<BooksEntity> byStatus(@Param("status") String status);
    List<BooksEntity> byShelf(@Param("shelf") String shelf);
}
