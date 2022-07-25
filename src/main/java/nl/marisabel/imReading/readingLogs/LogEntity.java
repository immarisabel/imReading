package nl.marisabel.imReading.readingLogs;

import lombok.Data;
import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name = "LogEntity.byBookId", query = "FROM LogEntity WHERE bookId = ?1")
@Data
@Table(name = "logs")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id")
    private BooksEntity bookId;
    @Column(columnDefinition = "TEXT")
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String mood;
    @Column(nullable = false)
    private int page;


}
