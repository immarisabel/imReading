package nl.marisabel.imReading.books;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
        "title",
        "isbn",
        "pageCount",
        "publishedDate",
        "thumbnailUrl",
        "shortDescription",
        "longDescription",
        "status",
        "authors",
        "categories"
})
@Generated("jsonschema2pojo")
public class BooksJson implements Serializable
{

    @JsonProperty("title")
    private String title;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("pageCount")
    private long pageCount;
    @JsonProperty("publishedDate")
    private PublishedDateModel publishedDateModel;
    @JsonProperty("thumbnailUrl")
    private String thumbnailUrl;
    @JsonProperty("shortDescription")
    private String shortDescription;
    @JsonProperty("longDescription")
    private String longDescription;
    @JsonProperty("status")
    private String status;
    @JsonProperty("authors")
    private List<String> authors = null;
    @JsonProperty("categories")
    private List<String> categories = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5989281043752640200L;

    /**
     * No args constructor for use in serialization
     *
     */
    public BooksJson() {
    }

    /**
     *
     * @param longDescription
     * @param pageCount
     * @param isbn
     * @param publishedDateModel
     * @param shortDescription
     * @param categories
     * @param title
     * @param thumbnailUrl
     * @param status
     * @param authors
     */
    public BooksJson(String title, String isbn, long pageCount, PublishedDateModel publishedDateModel, String thumbnailUrl, String shortDescription, String longDescription, String status, List<String> authors, List<String> categories) {
        super();
        this.title = title;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.publishedDateModel = publishedDateModel;
        this.thumbnailUrl = thumbnailUrl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.status = status;
        this.authors = authors;
        this.categories = categories;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @JsonProperty("pageCount")
    public long getPageCount() {
        return pageCount;
    }

    @JsonProperty("pageCount")
    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    @JsonProperty("publishedDate")
    public PublishedDateModel getPublishedDate() {
        return publishedDateModel;
    }

    @JsonProperty("publishedDate")
    public void setPublishedDate(PublishedDateModel publishedDateModel) {
        this.publishedDateModel = publishedDateModel;
    }

    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @JsonProperty("thumbnailUrl")
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @JsonProperty("shortDescription")
    public String getShortDescription() {
        return shortDescription;
    }

    @JsonProperty("shortDescription")
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @JsonProperty("longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    @JsonProperty("longDescription")
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("authors")
    public List<String> getAuthors() {
        return authors;
    }

    @JsonProperty("authors")
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @JsonProperty("categories")
    public List<String> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
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
        sb.append(BooksJson.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("isbn");
        sb.append('=');
        sb.append(((this.isbn == null)?"<null>":this.isbn));
        sb.append(',');
        sb.append("pageCount");
        sb.append('=');
        sb.append(this.pageCount);
        sb.append(',');
        sb.append("publishedDate");
        sb.append('=');
        sb.append(((this.publishedDateModel == null)?"<null>":this.publishedDateModel));
        sb.append(',');
        sb.append("thumbnailUrl");
        sb.append('=');
        sb.append(((this.thumbnailUrl == null)?"<null>":this.thumbnailUrl));
        sb.append(',');
        sb.append("shortDescription");
        sb.append('=');
        sb.append(((this.shortDescription == null)?"<null>":this.shortDescription));
        sb.append(',');
        sb.append("longDescription");
        sb.append('=');
        sb.append(((this.longDescription == null)?"<null>":this.longDescription));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("authors");
        sb.append('=');
        sb.append(((this.authors == null)?"<null>":this.authors));
        sb.append(',');
        sb.append("categories");
        sb.append('=');
        sb.append(((this.categories == null)?"<null>":this.categories));
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

