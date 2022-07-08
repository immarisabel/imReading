package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Integer> {


    List<LogEntity> byBookId(@Param("bookId") BooksEntity bookId);


}
