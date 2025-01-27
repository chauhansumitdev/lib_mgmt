package Person;

import java.util.ArrayList;
import java.util.*;

public class UserManagement {
    List<Person> users = new ArrayList<>();

    public void add_user(Person person){
        users.add(person);
    }

    public void remove_user(Person person){
        for(Person current_person : users){
            if(current_person == person){
                users.remove(person);
                return;
            }
        }
    }

    public boolean is_user_subscribed(Person person){
        if(users.contains(person)){
            return true;
        }

        return false;
    }

}
