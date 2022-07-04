package nl.marisabel.imReading.readingLogs;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntity, Long> {

    List<LogEntity> byOLid(@Param("OLid") String OLid);
    }
