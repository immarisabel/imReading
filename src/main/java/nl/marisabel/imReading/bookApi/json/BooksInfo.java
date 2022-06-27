
package nl.marisabel.imReading.bookApi.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class BooksInfo {


    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("covers")
    @Expose
    private List<Integer> covers = null;
    @SerializedName("subject_places")
    private List<String> subjectPlaces = null;
    @SerializedName("subjects")
    @Expose
    private List<String> key;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
