package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.TagsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TagsRepo extends JpaRepository<TagsEntity, Integer> {
}
