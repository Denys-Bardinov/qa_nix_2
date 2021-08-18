package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Book {
    private String id;
    public String name;
    public int year;
    public String comment;
}
