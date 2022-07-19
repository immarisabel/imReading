package nl.marisabel.imReading.shelves;

import lombok.*;
import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
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

    @ManyToMany(mappedBy = "shelves")
    private Set<BooksEntity> shelvedBooks;

    @ManyToMany
    @JoinTable(
            name = "shelved_books",
            joinColumns = @JoinColumn(name = "shelves_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<BooksEntity> books;

    public Set<BooksEntity> getBooksEntities() {
        return books;
    }

    public void setBooksEntities(Set<BooksEntity> booksEntities) {
        this.books = booksEntities;
    }
}
