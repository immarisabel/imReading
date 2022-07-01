package nl.marisabel.imReading.readingLogs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogsDaoImp implements LogsDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<LogEntity> getLogs() {

        // get hibernate session
        Session currentSession = sessionFactory.openSession();

        // create query
        Query<LogEntity> query =
                currentSession.createQuery("from LogEntity", LogEntity.class);


        // execute query
        List<LogEntity> logs = query.getResultList();
        logs.forEach(System.out::println);

        // return results
        return logs;
    }

    @Override
    public void saveLog(LogEntity logs) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(logs);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public LogEntity getLog(int id) {
        Session session = sessionFactory.openSession();
        return session.get(LogEntity.class, id);
    }

    @Override
    public void deleteLog(int id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("delete from logs where id=:logId");
            query.setParameter("logId", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
