package nl.marisabel.imReading.dto;

import lombok.Data;

@Data
public class LogDto {

    private String book;
    private int rating;
    private boolean favorite;
    private String shelf;
    private String content;
    private String date;
    private String mood;
    private int page;
}
