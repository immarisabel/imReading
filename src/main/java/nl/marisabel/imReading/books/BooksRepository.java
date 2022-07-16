package nl.marisabel.imReading.books;

import nl.marisabel.imReading.libraries.LibrariesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntity, Integer> {

    List<BooksEntity> byStatus(@Param("status") String status);

    List<BooksEntity> byShelf(@Param("shelfId") LibrariesEntity shelfId);

    List<BooksEntity> isFavorite(@Param("favorite") boolean favorite);

}
