package com.jts.subscription.users.controller;

import com.jts.subscription.users.data.entity.User;
import com.jts.subscription.users.data.mapper.TelegramUserMapper;
import com.jts.subscription.users.data.telegram.TelegramUser;
import com.jts.subscription.users.repository.UserRepository;
import com.jts.subscription.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TelegramUserMapper telegramUserMapper;
    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUsers(@PathVariable UUID id) {
        return userService.getUsers(id);
    }

    @PostMapping
    public void createUsers(@RequestBody User users) {
        userService.createUsers(users);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable UUID id) {
        userService.deleteUsers(id);
    }

    @PostMapping("/save")
    public void saveTelegramUser(@RequestBody TelegramUser telegramUser) {
        User newUser = telegramUserMapper.mapToUser(telegramUser);
        userService.createUsers(newUser);
    }

    @GetMapping("/getID/{telegramId}")
    public UUID getUserIdByTelegramId(@PathVariable String telegramId) {
        return userRepository.findUserByTelegramId(telegramId).getId();
    }
}
