package nl.marisabel.imReading.services;

import nl.marisabel.imReading.entities.BooksEntity;
import nl.marisabel.imReading.repositories.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Books {

    @Autowired
    BooksRepo booksRepo;

    public List<BooksEntity> getReadBooks(){
        List<BooksEntity> books = new ArrayList<BooksEntity>();
        booksRepo.findAll().forEach(book -> books.add(book));
        return books;
    }

    public BooksEntity getBookbyIsbn(String isbn){
        return  booksRepo.findById(isbn).get();
    }

    public void saveOrUpdate(BooksEntity books){
        booksRepo.save(books);
    }

    public void delete(String isbn){
        booksRepo.deleteById(isbn);
    }
}
