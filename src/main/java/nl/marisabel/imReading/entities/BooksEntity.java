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
    private String isbn;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    private String thumbnailUrl;
    private String shortDescription;
//    @ManyToOne
//    @JoinColumn(name = "genre_id")
//    private GenreEntity genre;
//    @ManyToOne
//    @JoinColumn(name = "tags_id")
//    private TagsEntity tags;
    private String status; // ENUM?
    private int rating = 0; // default is 0, update when finished
}
