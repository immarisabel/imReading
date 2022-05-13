package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepo extends JpaRepository<LogEntity, Integer> {


}
