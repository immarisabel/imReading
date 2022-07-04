package nl.marisabel.imReading.readingLogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LogsService {

    @Autowired
    LogRepository logRepository;
    public List<LogEntity> getLogs(){
        List<LogEntity> logs = new ArrayList<LogEntity>();
        logRepository.findAll().forEach(logs::add);
        return logs;
    }

   // List<LogEntity> getBookLogs(String OLid);

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
