package Entry;

import java.util.*;

import Person.Person;
import Rack.Rack;

/**
 * MARK : ENTRY
 * DESC : THIS IS THE ENTRY CLASS THAT CONTAINS THE FIELDS FOR PERSON TO WHICH THE BOOK IS ASSIGNED, DATE ON WHICH IT IS ASSIGNED, RACK ON WHICH IT IS PHYSICALLY PRESENT AND RESERVED IF THE BOOK IS ALREADY ALLOTED THEN IT CAN BE RESERVED TO A SPECIFIC PERSON
 */
public class Entry {
    Person person;
    Date date;
    Rack rack;
    Person reserved;

    public Entry(){
        person = null;
        date = null;
        rack = null;
        reserved = null;
    }

    public Person get_person(){
        return person;
    }

    public Date get_date(){
        return date;
    }

    public Rack get_rack(){
        return rack;
    }

    public Person get_reserved_person(){
        return reserved;
    }

    public void set_rack(Rack rack){
        this.rack = rack;
    }

    public void set_person(Person person){
        this.person = person;
    }

    public void set_date(){
        date = new Date();
    }

    public void set_date(Date date){
        this.date = date;
    }

    public void reserve_book(Person person){
        this.person = person;
    }
}
