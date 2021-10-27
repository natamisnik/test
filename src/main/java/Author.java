import java.util.List;

public class Author {
    private String lastname;
    private String firstname;
    private List<Book> books;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override

    public String toString(){
        return "lastname "+ lastname +  " firstname "+ firstname+ " books: " +books;
    }

    //public List<Book> getBooks() {
   //     return books;
   // }

    //public void setBooks(List<Book> books) {
    //    this.books = books;
    //}
}
