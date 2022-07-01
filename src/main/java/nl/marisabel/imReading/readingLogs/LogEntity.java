package nl.marisabel.imReading.readingLogs;

import lombok.Data;
import nl.marisabel.imReading.books.BooksEntity;

import javax.persistence.*;

@Entity
@Data
@Table(name = "logs")
public class LogEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "o_lid_o_lid", columnDefinition="varchar(255)")
    private BooksEntity OLid;
    private String book;
    private String shelf;

    @Column(columnDefinition="TEXT")
    private String content;
    private String date;
    private String mood;
    private int page;


}
