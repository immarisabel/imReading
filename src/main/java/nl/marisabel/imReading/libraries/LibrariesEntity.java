package nl.marisabel.imReading.libraries;

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
@Table(name = "libraries")
public class LibrariesEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
