package com.cursor.spring.demo.repository;

import com.cursor.spring.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findUserByEmail(String email);

    @Query(value = "{}", fields = "{'email' : 1}")
    List<User> findUsersOnlyWithEmails();
}
