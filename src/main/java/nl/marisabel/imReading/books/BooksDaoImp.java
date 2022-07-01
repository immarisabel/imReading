package nl.marisabel.imReading.books;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class BooksDaoImp implements BooksDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<BooksEntity> getBooks() {

        Session currentSession = sessionFactory.openSession();
        Query<BooksEntity> query =
                currentSession.createQuery("from BooksEntity", BooksEntity.class);
        List<BooksEntity> books = query.getResultList();
        books.forEach(System.out::println);
        return books;
    }

    @Override
    public void saveBook(BooksEntity books) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(books);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public BooksEntity getBook(int id) {
        Session session = sessionFactory.openSession();
        return session.get(BooksEntity.class, id);    }

    @Override
    public void deleteBook(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Query query = session.createQuery("delete from books where id=:bookId");
            query.setParameter("bookId", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
