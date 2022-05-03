package nl.marisabel.imReading.journal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.marisabel.imReading.books.BooksEntity;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private BooksEntity book;

    @ManyToOne
    @JoinColumn(name = "journal_entries_id")
    private EntryEntity journalEntries;

    private int rating;
    private boolean favorite;
    private String shelf;
}
