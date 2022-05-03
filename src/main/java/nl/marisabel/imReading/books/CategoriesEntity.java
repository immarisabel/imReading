package nl.marisabel.imReading.books;

import javax.persistence.*;

@Entity
public class CategoriesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category", nullable = false)
    private Long category;

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    private String categoryName;
}
