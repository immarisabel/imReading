
package nl.marisabel.imReading.searchApi.POJO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {

    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("author")
    @Expose
    private Author__1 author;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
