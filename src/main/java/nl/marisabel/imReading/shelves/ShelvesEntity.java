package nl.marisabel.imReading.shelves;

import lombok.*;
import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "shelves")
public class ShelvesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "shelves")
    @ToString.Exclude
    private Set<BooksEntity> shelvedBooks;

    @ManyToMany
    @JoinTable(
            name = "shelved_books",
            joinColumns = @JoinColumn(name = "shelves_id"),
            inverseJoinColumns = @JoinColumn(name = "books_id"))
    @ToString.Exclude
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<BooksEntity> books = new HashSet<>();

    public Set<BooksEntity> getBooksEntities() {
        return books;
    }

    public void setBooksEntities(Set<BooksEntity> booksEntities) {
        this.books = booksEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ShelvesEntity that = (ShelvesEntity) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
