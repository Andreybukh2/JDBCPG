package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDto {
    private String titleOfBook;
    private int yearOfPublication;
    private String author;
}
