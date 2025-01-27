package Book;

public class Book {

    String title;
    String author;
    String category;
    int publication_year;

    /**
     * MARK : BOOK
     * DESC : THIS IS THE CONSTRUCTIOR FOR CONTAINING PARAMETERS
     * @param title
     * @param author
     * @param category
     * @param publication_year
     */
    public Book(String title, String author, String category, int publication_year){
        this.title = title;
        this.author = author;
        this.category = category;
        this.publication_year = publication_year;
    }

    public String get_title(){
        return title;
    }

    public String get_author(){
        return author;
    }

    public String get_category(){
        return category;
    }

    public int get_publication_year(){
        return publication_year;
    }
}