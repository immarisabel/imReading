package nl.marisabel.imReading.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.marisabel.imReading.libraries.LibrariesEntity;
import nl.marisabel.imReading.readingLogs.LogEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({@NamedQuery(name = "BooksEntity.byStatus", query = "FROM BooksEntity WHERE status = ?1"),
@NamedQuery(name = "BooksEntity.byShelf", query = "FROM BooksEntity WHERE shelves = ?1"),
        @NamedQuery(name = "BooksEntity.isFavorite", query = "FROM BooksEntity WHERE favorite = ?1")
})
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
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JoinColumn(name = "shelves_id")
    private LibrariesEntity shelves;
}
