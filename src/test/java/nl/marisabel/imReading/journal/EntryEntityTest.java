package nl.marisabel.imReading.journal;

import lombok.extern.slf4j.Slf4j;
import nl.marisabel.imReading.books.BooksEntity;
import nl.marisabel.imReading.books.BooksRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
class EntryEntityTest {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private JournalRepository journalRepository;

    @Test
    public void createEntry(){
        BooksEntity book = BooksEntity.builder()
                .isbn("0-345-24223-8")
                .author("M Munoz")
                .title("My life")
                .mainGenre("Biography")
                .secondaryGenre("Feel Good")
                .shortDescription("blah blah")
                .thumbnailUrl("http://")
                .build();

        JournalEntity journal = JournalEntity.builder()
                .book(book)
                .id(123)
                .favorite(false)
                .rating(3)
                .shelf("Read")
                .journalEntries(  EntryEntity.builder()
                        .content("test")
                        .id(123)
                        .date("April 22, 2022")
                        .build())
                .build();
        log.info(journal.getBook().getTitle());

        assertEquals("My life", journal.getBook().getTitle());
    }



}