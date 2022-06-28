package nl.marisabel.imReading.services;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import nl.marisabel.imReading.entities.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

@Service
@Log4j2
public class GetNewBookService {

    @Autowired
    SearchBookService searchBookService;

    BooksEntity book;



    public void addNewBookFromApi(String bookId) throws IOException, InterruptedException {
        String jsonStringBookInfo = searchBookService.getBookDetail(bookId);
        BooksInfo bookJson = new Gson().fromJson(jsonStringBookInfo, BooksInfo.class);
        String title = bookJson.getTitle();
        String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
        String jsonAuthorInfo = searchBookService.getAuthorDetails(authorKey);
        AuthorInfo authorJson = new Gson().fromJson(jsonAuthorInfo, AuthorInfo.class);
        String author = authorJson.getName();
        String cover = String.valueOf(bookJson.getCovers().get(0));

        boolean cached = false;

        String coverUrl = "https://covers.openlibrary.org/b/id/" + cover + "-M.jpg";

        log.info(">>>>>>>>>>>>>>> ID: " + bookId);
        log.info(">>>>>>>>>>>>>>> author: " + author);
        log.info(">>>>>>>>>>>>>>> title: " + title);
        log.info(">>>>>>>>>>>>>>> title: " + coverUrl);
        book.setAuthor(author);
        book.setTitle(title);
        book.setThumbnailUrl(coverUrl);
    }
}
