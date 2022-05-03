package nl.marisabel.imReading.books;

import javax.persistence.*;

@Entity
public class AuthorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String firstName;
    private String lastName;
}
