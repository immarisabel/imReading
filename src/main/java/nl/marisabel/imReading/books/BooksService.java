package nl.marisabel.imReading.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BooksService {
    @Autowired
    BooksRepository booksRepository;

    public List<BooksEntity> getAllBooks(){

        return null;
    }

    public BooksEntity getBookByISBN(String isbn){
        return null;
    }

    public void saveBook(BooksEntity books){
        booksRepository.save(books);
    }

    public void delete(String isbn){
        booksRepository.deleteAllById(Collections.singleton(isbn));

        //TODO check why Collections.singelton() instead of just isbn. String vs Int???
    }
}
