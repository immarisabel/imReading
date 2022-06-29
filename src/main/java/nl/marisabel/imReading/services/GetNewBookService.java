package nl.marisabel.imReading.services;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import nl.marisabel.imReading.entities.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log4j2
public class GetNewBookService {

    @Autowired
    SearchBookService searchBookService;

      public BooksEntity addNewBookFromApi(String OLid) throws IOException, InterruptedException {


        String jsonStringBookInfo = searchBookService.getBookDetail(OLid);

        BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
        String title = bookJson.getTitle();
        String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
        String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);
        String cover = String.valueOf(bookJson.getCovers().get(0));
        String coverUrl = "https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";

        AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
        String author = authorJson.getName();

        log.info(">>>>>>>>>>>>>>> ID: " + OLid);
        log.info(">>>>>>>>>>>>>>> author: " + author);
        log.info(">>>>>>>>>>>>>>> title: " + title);
        log.info(">>>>>>>>>>>>>>> cover: " + coverUrl);

        BooksEntity book = new BooksEntity();
        book.setAuthor(author);
        book.setTitle(title);
        book.setThumbnailUrl(coverUrl);
        return book;
    }
}
