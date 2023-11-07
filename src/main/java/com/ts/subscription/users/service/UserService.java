package com.ts.subscription.users.service;

import com.ts.subscription.users.data.entity.User;
import com.ts.subscription.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUsers(User user) {
        String telegramId = user.getTelegramId();
        if (userRepository.existsUsersByTelegramId(telegramId)) {
            log.info(format("User with telegramId[%s] already exist", telegramId));
        } else {
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
