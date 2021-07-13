package com.example.demo.repository;

import com.example.demo.entity.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByName(String name);

    @Query("SELECT u FROM User u WHERE u.name = ?1 OR u.email = ?1")
    Optional<List<User>> findUsersByNameOrEmail(String name);
}

