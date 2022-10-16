package com.jts.subscription.users.service;

import com.jts.subscription.users.data.entity.User;
import com.jts.subscription.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createUsers(User user) {
        User tempUser = userRepository.findUserByTelegramId(user.getTelegramId());
        if(tempUser == null)
            userRepository.save(user);
        else updateUsers(user);
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
