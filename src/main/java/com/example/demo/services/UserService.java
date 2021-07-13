package com.example.demo.services;

import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private List<User> users;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<List<User>> findByUserNameOrEmail(String searchVal){
        return userRepository.findUsersByNameOrEmail(searchVal);
    }
//    // Love Java 8
//    public List<User> findByUserNameOrEmail(String username) {
//
//        List<User> result = users.stream()
//                .filter(x -> x.getUsername().equalsIgnoreCase(username))
//                .collect(Collectors.toList());
//
//        return result;
//
//    }

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

//        users = new ArrayList<User>();
//
        User user1 = new User("Pokemon","pokemon@gmail.com");
        User user2 = new User("Pikajoo","pikajoo@gmail.com");
        User user3 = new User("sarawutt.b","sarawutt.b@gmail.com");
//
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


    }
}
