package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepo extends JpaRepository<LogEntity, Integer> {
}
