package com.ts.subscription.users.service;

import com.ts.subscription.users.data.entity.User;
import com.ts.subscription.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createUsers(User user) {
        if (userRepository.existsUsersByTelegramId(user.getTelegramId())) updateUsers(user);
        else {
            userRepository.save(user);
        }
    }

    public User getUsers(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteUsers(UUID id) {
        userRepository.deleteById(id);
    }

    public void updateUsers(User user) {
        User tempUser = userRepository.findUserByTelegramId(user.getTelegramId());
        tempUser.setFirstName(user.getFirstName());
        tempUser.setLastName(user.getLastName());
        tempUser.setUserName(user.getUserName());
        userRepository.save(tempUser);
    }

}
