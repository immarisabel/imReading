package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.repositories.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Logs
{
    @Autowired
    private LogRepo logRepo;


    @Transactional
    public void saveOrUpdate(LogEntity logs){
        logRepo.save(logs);
    }

    @Transactional
    public List<LogEntity> getLogs() {
        return logRepo.findAll();
    }


}
