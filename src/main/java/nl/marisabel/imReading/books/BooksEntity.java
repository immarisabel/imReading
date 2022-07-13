package nl.marisabel.imReading.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.marisabel.imReading.readingLogs.LogEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
    private String title;
    private String author;
    @Column(nullable = false)
    private String thumbnailUrl;
    private String shortDescription;
    private String status; // ENUM?
    private int rating = 1; // default is 0, update when finished
    private boolean favorite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishedDate;
}
