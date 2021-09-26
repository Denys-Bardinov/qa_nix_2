package ua.com.alevel.demo.dto;

public class BookRequestDto {

    private String name;
    private String authorId;


    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return name;
    }

    public void setFirstname(String firstname) {
        this.name = firstname;
    }


}
