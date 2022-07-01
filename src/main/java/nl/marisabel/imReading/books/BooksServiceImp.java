package nl.marisabel.imReading.books;

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
    public BooksEntity getBook(int id) {
        return booksDao.getBook(id);
    }

    @Override
    public void deleteBook(int id) {
        booksDao.deleteBook(id);
    }
}
