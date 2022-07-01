package nl.marisabel.imReading.readingLogs;

import java.util.List;

public interface LogsService {

    public List<LogEntity> getLogs();

    void saveOrUpdate(LogEntity logs);

    LogEntity getLog(int id);

    void deleteLog(int id);

}
