package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


@Service
public class LogsService {

    @Autowired
    LogRepository logRepository;

    public List<LogEntity> getLogs() {
        List<LogEntity> logs = new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }

    List<LogEntity> byBookId(@Param("bookId") BooksEntity bookId) {
        List<LogEntity> logs = logRepository.byBookId(bookId);
        return logs;
    }


    LogEntity getLog(int id) {
        return logRepository.findById(id).get();
    }

    void saveOrUpdate(LogEntity logs) {
        logRepository.save(logs);
    }

    void deleteLog(int id) {
        logRepository.deleteById(id);
    }

}
