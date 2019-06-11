package com.cursor.spring.demo.service;

import com.cursor.spring.demo.dto.UserDTO;
import com.cursor.spring.demo.entity.User;
import com.cursor.spring.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User save(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        user.setEmail(userDTO.getEmail());
        user.setDataAccessId(UUID.randomUUID().toString());

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        Optional<User> userByEmail = userRepository.findUserByEmail(email);
        User user = userByEmail.orElseThrow(() ->
                new IllegalArgumentException("User doesn't exist"));
        return user;
    }

    public User updateUser(UserDTO userDTO) {

        User existedUser = getUserByEmail(userDTO.getEmail());
        User newUser = new User();
        newUser.setId(existedUser.getId());
        newUser.setEmail(userDTO.getEmail());
        newUser.setDataAccessId(existedUser.getDataAccessId());
        newUser.setAge(userDTO.getAge());
        newUser.setName(userDTO.getName());

        return userRepository.save(newUser);

    }

    public List<String> findUsersOnlyWirhEmails() {
        List<User> usersOnlyWithEmails = userRepository.findUsersOnlyWithEmails();
        return usersOnlyWithEmails.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }
}
