package nl.marisabel.imReading.books;

import com.google.gson.Gson;
import nl.marisabel.imReading.services.SearchBookService;
import nl.marisabel.imReading.bookApi.json.AuthorInfo;
import nl.marisabel.imReading.bookApi.json.BooksInfo;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {


    @Test
    public void JsonBookInformationAPiTest() throws IOException, InterruptedException {
        SearchBookService searchBookService = new SearchBookService();

        String jsonBookInfo = searchBookService.getBookDetail("OL17930368W");


        // BOOK
        BooksInfo bookJson = new Gson().fromJson(jsonBookInfo, BooksInfo.class);
        System.out.println(bookJson.getTitle());


        // COVER
        String coverId = String.valueOf(bookJson.getCovers().get(0));
        System.out.println("https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg");


        // AUTHOR
        String authorKey = bookJson.getAuthors().get(0).getAuthor().getKey();
        String authorDetails = searchBookService.getAuthorDetails(authorKey);
        AuthorInfo authorInfo = new Gson().fromJson(authorDetails, AuthorInfo.class);
        System.out.println(authorInfo.getName());


        // System.out.println(bookJson.getDescription1().getValue());
        //TODO The problem is that there are 2 type of Descriptions,
        // String and Object. We cannot have 2 Json fields named the same.
        // So how can we add them both without conflict?
        // For now we work without description.

    }


}
