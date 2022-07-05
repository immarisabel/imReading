package nl.marisabel.imReading.readingLogs;

import nl.marisabel.imReading.books.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


@Service
public class LogsService {

    @Autowired
    LogRepository logRepository;
    
    public List<LogEntity> getLogs(){
        List<LogEntity> logs = new ArrayList<>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }

    List<LogEntity> byBookId(@Param("bookId") BooksEntity bookId){
       List<LogEntity> logs = logRepository.byBookId(bookId);
       System.out.println(logs);
       return logs;
   }


   LogEntity getLog(long id)
   {
       return logRepository.findById(id).get();
   }

    void saveOrUpdate(LogEntity logs)
    {
        logRepository.save(logs);
    }


    void deleteLog(long id)
    {
        logRepository.deleteById(id);
    }

}
