package nl.marisabel.imReading.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "logs")
public class LogEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String book;
    private int rating;
    private boolean favorite;
    private String shelf;
    private String content;
    private String date;
    private String mood;
    private int page;

}
