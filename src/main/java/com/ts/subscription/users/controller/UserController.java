package com.ts.subscription.users.controller;

import com.ts.subscription.users.data.dto.UserCreateRequest;
import com.ts.subscription.users.data.entity.User;
import com.ts.subscription.users.data.mapper.TelegramUserMapper;
import com.ts.subscription.users.repository.UserRepository;
import com.ts.subscription.users.service.UserService;
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

    @PostMapping
    public void saveTelegramUser(@RequestBody UserCreateRequest telegramUser) {
        User newUser = telegramUserMapper.mapToUser(telegramUser);
        userService.createUsers(newUser);
    }

    @GetMapping("/getID/{telegramId}")
    public UUID getUserIdByTelegramId(@PathVariable String telegramId) {
        return userRepository.findUserByTelegramId(telegramId).getId();
    }
}
