package nl.marisabel.imReading.books;

import nl.marisabel.imReading.libraries.LibrariesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public List<BooksEntity> getBooks(){
        List<BooksEntity> books = new ArrayList<BooksEntity>();
        booksRepository.findAll().forEach(books::add);
        return books;
    }

    public BooksEntity getBook(int id)
    {
        return booksRepository.findById(id).get();
    }

    void saveOrUpdate(BooksEntity book)
    {
        booksRepository.save(book);
    }

    void deleteBook(int id)
    {
        booksRepository.deleteById(id);
    }

    public List<BooksEntity> byStatus(@Param("status") String status){
        List<BooksEntity> books = booksRepository.byStatus(status);
        return books;
    }

    public List<BooksEntity> byShelf(@Param("shelfId") LibrariesEntity shelfId){
        List<BooksEntity> books = booksRepository.byShelf(shelfId);
        return books;
    }


}
