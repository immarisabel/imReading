package nl.marisabel.imReading.searchApi;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.searchApi.POJO.AuthorInfo;
import nl.marisabel.imReading.searchApi.POJO.BooksInfo;
import nl.marisabel.imReading.books.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AddBookService {

    @Autowired
    SearchBookService searchBookService;


    public BooksEntity addNewBookFromApi(String OLid, BooksEntity book) throws IOException, InterruptedException {

        String jsonStringBookInfo = searchBookService.getBookDetail(OLid);
        BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
        System.out.println(bookJson);
        String title = bookJson.getTitle();
        String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
        System.out.println(authorKey);
        String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);

//        When there is no cover, add nocover as main cover

        if (bookJson.getCovers() == null) {
            book.setThumbnailUrl("/images/nocover.svg");
        } else {
            String cover = String.valueOf(bookJson.getCovers().get(0));
            String coverUrl = "https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";
            book.setThumbnailUrl(coverUrl);
        }

//        When no author found, add "Author Unknown" as author

        if (bookJson.getAuthors() == null) {
            book.setAuthor("Author Unkown");
        } else {
            AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
            String author = authorJson.getName();
            book.setAuthor(author);
        }

        book.setTitle(title);

        return book;
    }
}
