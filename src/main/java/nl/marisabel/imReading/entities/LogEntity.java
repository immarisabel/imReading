package nl.marisabel.imReading.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="logs")
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_isbn")
    private BooksEntity book;
    private int rating;
    private boolean favorite;
    private String shelf;
    private String content;
    private String date;
    private int mood;
    private int page;

}
