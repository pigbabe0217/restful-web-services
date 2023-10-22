package com.in28minutes.rest.webservices.restfulwebservices.user;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    //JPA Hibernate
    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    static {
        users.add(new User(++userCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(20)));

    }
    public List<User> findAll(){
        return users;
    }
    public User findOne(int id){
//        Predicate<? super User> predicate = user -> user.getId().equals(id);
//        return users.stream().filter(predicate).findFirst().get();
        for (User user: users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if (user.getId() == id){
                iterator.remove();
                return;
            }
        }


    }
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

}
