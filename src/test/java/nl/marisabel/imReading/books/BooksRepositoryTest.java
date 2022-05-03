package nl.marisabel.imReading.books;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.awt.print.Book;
import java.util.List;

@DataJpaTest //only scans repositories
class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;


    @BeforeEach
    public BooksEntity bookSample(){
        BooksEntity book = BooksEntity.builder()
                .isbn("0-345-24223-8")
                .author("M Munoz")
                .title("My life")
                .mainGenre("Biography")
                .secondaryGenre("Feel Good")
                .shortDescription("blah blah")
                .thumbnailUrl("http://")
                .build();
        return book;
    }

    @Test
    public void saveBookTest() {

        booksRepository.save(bookSample());
        Assertions.assertThat(bookSample().getIsbn()).isNotEmpty();
    }

    @Test
    public void getBookTest(){
        BooksEntity book = booksRepository.findById("0-345-24223-8").get();

        Assertions.assertThat(book.getIsbn()).isEqualTo("0-345-24223-8");
    }

    @Test
    public void getBooksTest(){
        List<BooksEntity> books = booksRepository.findAll();

        Assertions.assertThat(books.size()).isGreaterThan(0);
    }
}