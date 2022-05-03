package nl.marisabel.imReading.journal;

import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EntryEntityTest {

    @Autowired
    private BooksRepository booksRepository;

    @BeforeEach
    public EntryEntity entrySample() {
//TODO how to nest builders for one2many?

//        EntryEntity entry = EntryEntity.builder()
//                .content("test")
//                .id(123)
//                .date("April 22, 2022")
//                .journal(
//                        JournalEntity.builder()
//                                .book( BooksEntity.builder()
//                                        .isbn("0-345-24223-8")
//                                        .author("M Munoz")
//                                        .title("My life")
//                                        .mainGenre("Biography")
//                                        .secondaryGenre("Feel Good")
//                                        .shortDescription("blah blah")
//                                        .thumbnailUrl("http://")
//                                )
//                )
//                .build();
//    }

    @Test
    void getId() {
    }

    @Test
    void getJournal() {
    }

    @Test
    void setJournal() {
    }
}