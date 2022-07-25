package nl.marisabel.imReading.searchApi.POJO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorInfo {
    @SerializedName("name")
    @Expose
    public String name;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
