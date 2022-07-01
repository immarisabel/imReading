package nl.marisabel.imReading.books;


import java.util.List;

public interface BooksDao {

    public List<BooksEntity> getBooks();

    void saveBook(BooksEntity books);

    BooksEntity getBook(int id);

    void deleteBook(int id);

}
