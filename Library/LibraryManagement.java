package Library;

import java.util.*;
import Book.Book;
import Entry.Entry;
import Rack.*;
import Person.*;


/**
 * MARK : LIBRARYMANAGEMENT
 * DESC : THIS IS THE LBRARY MANAGEMENT CLASS THAT CONTAINS VARIOUS FUNCTIONS FOR USER MANAGEMENT AND BOOK MANAGEMENT 
 */

public class LibraryManagement {

    Map<Book, Entry> map = new HashMap<>();
    UserManagement userManagement = new UserManagement();
   

    /**
     * MARK : ADD_BOOK
     * DESC : THIS IS USED TO ADD BOOK IF ITS ADDED BY THE ADMIN
     * @param admin
     * @param book
     * @param rack
     */
    public void add_book(Person admin, Book book, Rack rack){
        if(admin instanceof Admin){
            Entry entry = new Entry();
            entry.set_rack(rack);
            map.put(book, entry);
        }
    }

    /**
     * MARK : REMOVE_BOOK
     * DESC : THIS IS USED TO REMOVE BOOK IF ITS REMOVED BY THE ADMIN
     * @param person
     * @param book
     */
    public void remove_book(Person person, Book book){
        if(person instanceof Admin){
            if(map.containsKey(book) && map.get(book).get_person() == null){
                map.remove(book);
            }
        }
    }

    /**
     * MARK : SUBSCRIBE
     * DESC : THIS IS USED TO SUBSCRIBE THE USER IF ITS DONE BY THE ADMIN
     * @param admin
     * @param person
     */
    public void subscribe(Person admin, Person person){
        if(admin instanceof Admin){
            userManagement.add_user(person);
        }
    }

    /**
     * MARK : UNSUBSCRIBE
     * DESC : THIS IS USED TO UNSUBSCRIBE THE USER IF ITS DONE BY THE ADMIN
     * @param admin
     * @param person
     */
    public void unsubscribe(Person admin, Person person){
        if(admin instanceof Admin){
            userManagement.remove_user(person);
        }
    }


    /**
     * MARK : SEARCH_BOOK_BY_TITLE
     * DESC : THIS IS USED TO SEARCH BOOK BY TITLE
     * @param title
     */
    public void search_book_by_title(String title){

        for(Book book : map.keySet()){

            if(book.get_title().equals(title)){
                System.out.println(book);
            }

        }

    }

    /**
     * MARK : SEARCH_BY_AUTHOR
     * DESC : THIS IS USED TO SEARCH THE BOOK BY AUTHOR
     * @param author
     */
    public void search_by_author(String author){
        for(Book book : map.keySet()){
            if(book.get_author().equals(author)){
                System.out.println(book);
            }
        }
    }

    /**
     * MARK : SEARCH_BOOK_BY_CATEGORY
     * DESC : THIS FUNCITON IS USED TO SEARCH BOOK BY CATEGORY
     * @param category
     */
    public void search_by_category(String category){
        for(Book book : map.keySet()){
            if(book.get_category().equals(category)){
                System.out.println(book);
            }
        }
    }

    /**
     * MARK : SEARCH_BOOK_BY_PUBLICATION_DATE
     * DESC : THIS FUNCTION IS USED TO SEARCH BY PUBLICATION DATE
     * @param date
     */
    public void search_by_publication_date(int date){
        for(Book book : map.keySet()){
            if(book.get_publication_year() == date){
                System.out.println(book);
            }
        }
    }


    /**
     * MARK : CHECK_OUT_BOOK
     * DESC : THIS FUNCITO IS USED TO PURCHASE AND CHECKOUT BOOK
     * @param admin
     * @param person
     * @param book
     */
    public void check_out_book(Person admin ,Person person, Book book){

        if(!(admin instanceof Admin)){
            return;
        }

        if(userManagement.is_user_subscribed(person)){
            if(map.containsKey(book)){

                int count = 0;

                for(Entry entry : map.values()){

                    if(entry.get_person() == person){
                        count++;
                    }

                }

                if(count > 5){
                    return;
                }

                Entry current_entry = map.get(book);
                current_entry.set_person(person);
                current_entry.set_date();

            }
        }

    }

    /**
     * MARK : RETURN_BOOK
     * DESC : THIS FUNCTION IS USED TO RETURN BOOK
     * @param admin
     * @param person
     * @param book
     */
    public void return_book(Person admin, Person person , Book book){
        if(admin instanceof Admin){

            Entry entry = map.get(book);
            Date date = entry.get_date();
            Date current_date = new Date();

            // generate fine if date exceed;

            entry.set_date(null);
            entry.set_person(null);
        }
    }


    /**
     * MARK : SEND_NOTIFICATION
     * DESC : THIS FUNCTION IS USED TO SEND NOTIFICATION
     */
    public void send_notification(){
        
        for(Entry current_entry : map.values()){
            if(current_entry.get_person() == null && current_entry.get_reserved_person() != null){
                current_entry.get_reserved_person().notify_user();
            }

            // if the dates increase then also send the notif to user
            current_entry.get_person().notify_user();
        }
    }

    public void generate_fine(){
        System.out.println("FINE GENERATED");
    }

    /**
     * MARK : RESERVE_BOOK
     * DESC : THIS FUNCITON IS USED TO RESERVE A BOOK IF ITS OWNED BY SOMEONE ELSE
     * @param admin
     * @param person
     * @param book
     */
    public void reserve_book(Person admin, Person person, Book book){

        if(admin instanceof Admin){
            if(map.containsKey(book) && map.get(book).get_person() != null){
                map.get(book).reserve_book(person);
            }
        }
    }

    public void book_info(Person admin, Book book){
        if(admin instanceof Admin){
            if(map.containsKey(book)){
                print_entry(map.get(book));
            }
        }
    }

    /**
     * MARK : BOOK_TAKEN_BY_USER
     * DESC : THIS IS USED TO LIST THE BOOKS TAKEN BY A CERTAIN USER
     * @param admin
     * @param person
     */
    public void book_taken_by_user(Person admin, Person person){
        if(admin instanceof Admin){

            for(Map.Entry<Book , Entry> entry : map.entrySet()){
                Book current_book = entry.getKey();
                Entry current_entry = entry.getValue();
                if(current_entry.get_person() == person){
                    System.out.println(current_book);
                }
            }

        }
    }

    public void print_entry(Entry entry){
        System.out.println(entry.get_person());
        System.out.println(entry.get_rack());
        System.out.println(entry.get_reserved_person());
        System.out.println(entry.get_date());
    }


    public void print_db(){
        for(Map.Entry<Book, Entry> entry : map.entrySet()){
            System.out.println(entry.getKey());
            print_entry(entry.getValue());
        }
    }
}

