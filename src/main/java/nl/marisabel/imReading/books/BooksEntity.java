package nl.marisabel.imReading.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.marisabel.imReading.readingLogs.LogEntity;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "BooksEntity.byStatus", query = "FROM BooksEntity WHERE status = ?1")
@Builder
@Table(name = "books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "olid", unique = true, nullable = false)
    private String OLid;
    private String title;
    private String author;
    @Column(nullable = false)
    private String thumbnailUrl;
    private String shortDescription;
    private String status; // ENUM?
    private int rating = 0; // default is 0, update when finished
    private boolean favorite;
    private String startDate;
    private String finishedDate;
}
