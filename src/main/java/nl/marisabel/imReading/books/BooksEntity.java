package nl.marisabel.imReading.books;

import lombok.*;
import nl.marisabel.imReading.shelves.ShelvesEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({@NamedQuery(name = "BooksEntity.byStatus", query = "FROM BooksEntity WHERE status = ?1 ORDER BY finished_date DESC"),
        @NamedQuery(name = "BooksEntity.byShelf", query = "FROM BooksEntity u join u.shelves r WHERE r.id=:shelfId"),
        @NamedQuery(name = "BooksEntity.byRating", query = "FROM BooksEntity WHERE rating = ?1"),
        @NamedQuery(name = "BooksEntity.isFavorite", query = "FROM BooksEntity WHERE favorite = ?1")})
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
    private String status;
    private int rating = 0;
    private boolean favorite;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishedDate;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "shelved_books",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "shelves_id"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<ShelvesEntity> shelves = new HashSet<>();


}
