package nl.marisabel.imReading.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="books")
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int isbn;
    private String title;
    private String author;
    private String thumbnailUrl;
    private String shortDescription;
    private String status; // ENUM?
    private int rating = 0; // default is 0, update when finished
    private boolean favorite;
}
