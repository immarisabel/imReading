package nl.marisabel.imReading.books;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class BooksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String isbn;
    private String title;
    private long pageCount;
    private String thumbnailUrl;
    private String shortDescription;
    private String longDescription;
    private String status;
    private Long authorId;
    private Long categoryId;
    private String date;
}
