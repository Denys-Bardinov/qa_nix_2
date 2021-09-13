package ua.com.alevel.demo.entity;

public class Author {
    private String id;
    private String firstname;
    private String lastname;
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public static Builder newAuthor() {
        return new Author().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(String id) {
            Author.this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            Author.this.firstname = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            Author.this.lastname = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            Author.this.email = email;
            return this;
        }


        public Author build() {
            return Author.this;
        }
    }
}
