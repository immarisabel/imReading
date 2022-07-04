package nl.marisabel.imReading.searchApi;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.searchApi.POJO.AuthorInfo;
import nl.marisabel.imReading.searchApi.POJO.BooksInfo;
import nl.marisabel.imReading.books.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class AddBookService {

    @Autowired
    SearchBookService searchBookService;


    public BooksEntity addNewBookFromApi(String OLid, BooksEntity book) throws IOException, InterruptedException {

        log.info(OLid);

        String jsonStringBookInfo = searchBookService.getBookDetail(OLid);

        BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);

        String title = bookJson.getTitle();
        String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
        String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);
        String cover = String.valueOf(bookJson.getCovers().get(0));
        String coverUrl = "https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";

        if (bookJson.getCovers().get(0) == null) {
            coverUrl = "/images/no-image.png";
        }

        AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
        String author = authorJson.getName();

        book.setAuthor(author);
        book.setTitle(title);
        book.setThumbnailUrl(coverUrl);

        return book;
    }
}