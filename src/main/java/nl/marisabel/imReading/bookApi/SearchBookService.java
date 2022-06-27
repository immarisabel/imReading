package nl.marisabel.imReading.bookApi;


import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class SearchBookService {
    private final String api = "https://openlibrary.org/search.json?fields=title,key&limit=20";
    Logger logger = Logger.getLogger(SearchBookService.class.getName());


    public HashMap<String, String> search(String searchTerm) {
        HashMap<String, String> results = new HashMap<>();
        RestTemplate template = new RestTemplate();
        String url = api + "&q=" + searchTerm;


        RequestEntity<Void> req = RequestEntity.get(url)
                .accept(MediaType.APPLICATION_JSON)
                .build();

        ResponseEntity<String> resp = template.exchange(req, String.class);

        try (InputStream inputStream = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(inputStream);
            JsonObject data = reader.readObject();
            JsonArray searchArray = data.getJsonArray("docs");

            List<JsonObject> keyandTitle = searchArray.stream()
                    .map(f -> (JsonObject) f)
                    .toList();
            keyandTitle.forEach(f -> results.put(f.getString("key"), f.getString("title")));
            System.out.println(results);

            return results;
        } catch (IOException e) {
            logger.warning("IOException in reading json");
        }
        return results;
    }



    public String getAuthorDetails(String authorId) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openlibrary.org" + authorId +".json"))
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }


    public String getBookDetail(String workId) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://openlibrary.org/works/" + workId +".json"))
                .method("GET", HttpRequest.BodyPublishers.noBody()).build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }




}