package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.repositories.LogsDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LogServiceImp implements LogsService{

    @Autowired
    private LogsDao logsDao;


    @Override
    public List<LogEntity> getLogs() {
        return logsDao.getLogs();
    }

    @Override
    public void saveOrUpdate(LogEntity logs) {
        logsDao.saveLog(logs);
    }

    @Override
    public LogEntity getLog(int id) {
        return logsDao.getLog(id);
    }

    @Override
    public void deleteLog(int id) {
        logsDao.deleteLog(id);
    }
}
