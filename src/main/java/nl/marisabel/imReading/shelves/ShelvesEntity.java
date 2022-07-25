package nl.marisabel.imReading.shelves;

import lombok.*;
import nl.marisabel.imReading.books.BooksEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "shelves")
public class ShelvesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "shelved_books",
            joinColumns = @JoinColumn(name = "shelves_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    private Set<BooksEntity> books = new HashSet<>();

    @PreRemove
    private void removeBooksFromShelf() {
        getBooks().clear();
    }
}
