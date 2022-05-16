package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.LogEntity;
import nl.marisabel.imReading.repositories.LogsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class LogServiceImp implements LogsService{

    @Autowired
    private LogsDao logsDao;


    @Override
    @Transactional
    public List<LogEntity> getLogs() {
        return logsDao.getLogs();
    }

    @Override
    @Transactional
    public void saveOrUpdate(LogEntity logs) {
        logsDao.saveLog(logs);
    }

    @Override
    @Transactional
    public LogEntity getLog(int id) {
        return logsDao.getLog(id);
    }

    @Override
    @Transactional
    public void deleteLog(int id) {
        logsDao.deleteLog(id);
    }
}
