package nl.marisabel.imReading.repositories;

import nl.marisabel.imReading.entities.LogEntity;

import java.util.List;

public interface LogsDao {

    public List<LogEntity> getLogs();

    void saveLog(LogEntity logEntity);

    LogEntity getLog(int id);

    void deleteLog(int id);

}
