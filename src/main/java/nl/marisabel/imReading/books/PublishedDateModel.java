package nl.marisabel.imReading.books;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "$date"
})
@Generated("jsonschema2pojo")
public class PublishedDateModel implements Serializable
{

    @JsonProperty("$date")
    private String $date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -533257241673273512L;

    /**
     * No args constructor for use in serialization
     *
     */
    public PublishedDateModel() {
    }

    /**
     *
     * @param $date
     */
    public PublishedDateModel(String $date) {
        super();
        this.$date = $date;
    }

    @JsonProperty("$date")
    public String get$date() {
        return $date;
    }

    @JsonProperty("$date")
    public void set$date(String $date) {
        this.$date = $date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PublishedDateModel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("$date");
        sb.append('=');
        sb.append(((this.$date == null)?"<null>":this.$date));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
