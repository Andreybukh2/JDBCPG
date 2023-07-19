package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private int id;
    private String name;
    private String lastName;
    private int year;
    private String email;
}
