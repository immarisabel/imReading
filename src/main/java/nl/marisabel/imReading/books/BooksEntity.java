package nl.marisabel.imReading.books;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn;
    private String title;
    private String author;

    private String thumbnailUrl;
    private String shortDescription;
    private String mainGenre;
    private String secondaryGenre;

}
