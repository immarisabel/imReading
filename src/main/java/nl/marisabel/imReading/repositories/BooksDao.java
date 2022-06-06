package nl.marisabel.imReading.repositories;


import nl.marisabel.imReading.entities.BooksEntity;

import java.util.List;

public interface BooksDao {

    public List<BooksEntity> getBooks();

    void saveBook(BooksEntity books);

    BooksEntity getBook(int id);

    void deleteBook(int id);

}
