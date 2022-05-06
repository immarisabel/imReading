package nl.marisabel.imReading.books;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;


    @Test
    public void saveBookTest() {
        BooksEntity book = BooksEntity.builder()
                .isbn("0-345-24223-8")
                .author("M Munoz")
                .title("My life")
                .mainGenre("Biography")
                .secondaryGenre("Feel Good")
                .shortDescription("blah blah")
                .thumbnailUrl("http://")
                .build();
        booksRepository.save(book);
        assertNotNull(book.getIsbn());

        log.info(book.getTitle());
    }

    @Test
    public void getBookTest() {
        BooksEntity book = BooksEntity.builder()
                .isbn("0-345-24223-8")
                .author("M Munoz")
                .title("My life")
                .mainGenre("Biography")
                .secondaryGenre("Feel Good")
                .shortDescription("blah blah")
                .thumbnailUrl("http://")
                .build();
        assertNotNull(booksRepository.findById("0-345-24223-8"));
        assertEquals(book.getIsbn(), "0-345-24223-8");
    }

    @Test
    public void getBooksTest() {

        BooksEntity book = BooksEntity.builder()
                .isbn("0-345-24223-8")
                .author("M Munoz")
                .title("My life")
                .mainGenre("Biography")
                .secondaryGenre("Feel Good")
                .shortDescription("blah blah")
                .thumbnailUrl("http://")
                .build();
        booksRepository.save(book);

        List<BooksEntity> books = booksRepository.findAll();
        assertNotEquals(0, books.size());
    }
}