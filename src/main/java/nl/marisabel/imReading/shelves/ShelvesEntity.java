package nl.marisabel.imReading.shelves;

import lombok.*;
import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

//    @ManyToMany(mappedBy = "shelves")
//    private Set<BooksEntity> shelvedBooks;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "shelved_books",
            joinColumns = @JoinColumn(name = "shelves_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<BooksEntity> books = new HashSet<>();

}
