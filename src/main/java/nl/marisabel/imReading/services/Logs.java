package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.repositories.LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Logs
{
    @Autowired
    LogRepo logRepo;


    public void saveOrUpdate(LogEntity logs){
        logRepo.save(logs);
    }

}
