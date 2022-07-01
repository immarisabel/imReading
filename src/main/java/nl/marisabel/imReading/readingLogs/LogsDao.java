package nl.marisabel.imReading.readingLogs;

import java.util.List;

public interface LogsDao {

    public List<LogEntity> getLogs();

    void saveLog(LogEntity logEntity);

    LogEntity getLog(int id);

    void deleteLog(int id);

}
