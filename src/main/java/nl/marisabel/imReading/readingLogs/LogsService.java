package nl.marisabel.imReading.readingLogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

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

   List<LogEntity> byOLid(@Param("OLid") String OLid){

       List<LogEntity> logs = logRepository.byOLid(OLid);
       logRepository.findAll().forEach(logs::add);
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
