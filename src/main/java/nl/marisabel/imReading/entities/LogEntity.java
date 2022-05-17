package nl.marisabel.imReading.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "logs")
public class LogEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book")
    private String book;
    @Column(name = "rating")
    private int rating;
    @Column(name = "favorite")
    private boolean favorite;
    @Column(name = "shelf")
    private String shelf;
    @Column(name = "content")
    private String content;
    @Column(name = "date")
    private String date;
    @Column(name = "mood")
    private String mood;
    @Column(name = "page")
    private int page;

}
