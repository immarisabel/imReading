package nl.marisabel.imReading.readingLogs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Long> {
}
