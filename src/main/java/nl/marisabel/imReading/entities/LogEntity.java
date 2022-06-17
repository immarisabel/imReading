package nl.marisabel.imReading.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "logs")
public class LogEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "isbn_isbn")
    private BooksEntity isbn;
    private String book;
    private String shelf;

    @Column(columnDefinition="TEXT")
    private String content;
    private String date;
    private String mood;
    private int page;


}
