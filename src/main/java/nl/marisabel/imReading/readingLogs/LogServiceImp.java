package nl.marisabel.imReading.readingLogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
