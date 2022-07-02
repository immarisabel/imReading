package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;

import java.util.List;

public interface LogsDao {

    List<LogEntity> getLogs();

    void saveLog(LogEntity logEntity);

    LogEntity getLog(int id);

    List<LogEntity> getBookLogs(String OLid);

    void deleteLog(int id);

}
