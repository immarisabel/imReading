package nl.marisabel.imReading.readingLogs;

import lombok.*;
import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = "LogEntity.byBookId", query = "FROM LogEntity WHERE bookId = ?1")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "logs")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private BooksEntity bookId;

    private String shelf;
    @Column(columnDefinition = "TEXT")
    private String content;
    private String date;
    private String mood;
    private int page;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LogEntity logEntity = (LogEntity) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
