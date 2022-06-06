package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.repositories.BooksDaoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImp implements BooksService {

    @Autowired
    private BooksDaoImp booksDao;

    @Override
    public List<BooksEntity> getBooks() {
        return booksDao.getBooks();
    }

    @Override
    public void saveOrUpdate(BooksEntity book) {
        booksDao.saveBook(book);
    }

    @Override
    public BooksEntity getLog(int id) {
        return booksDao.getBook(id);
    }

    @Override
    public void deleteLog(int id) {
        booksDao.deleteBook(id);
    }
}
