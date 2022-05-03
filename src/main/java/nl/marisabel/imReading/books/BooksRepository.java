package nl.marisabel.imReading.books;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BooksRepository extends JpaRepository<BooksEntity, String> {
}
