package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.BooksEntity;

import java.util.List;

public interface BooksService {


    public List<BooksEntity> getBooks();

    void saveOrUpdate(BooksEntity book);

    BooksEntity getBook(int id);

    void deleteBook(int id);

}
