package com.jts.subscription.users.controller;

import com.jts.subscription.users.data.entity.Users;
import com.jts.subscription.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/{id}")
    public Users getUsers(@PathVariable UUID id) {
        return usersService.getUsers(id);
    }

    @PostMapping
    public Users createUsers(@RequestBody Users users) {
        return usersService.createUsers(users);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable UUID id) {
        usersService.deleteUsers(id);
    }

}
