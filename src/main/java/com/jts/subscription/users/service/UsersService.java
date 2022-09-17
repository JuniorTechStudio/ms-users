package com.jts.subscription.users.service;

import com.jts.subscription.users.data.entity.Users;
import com.jts.subscription.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public Users createUsers(Users users) {
        return usersRepository.save(users);
    }

    public Users getUsers(UUID id) {
        return usersRepository.findById(id).orElseThrow();
    }

    public void deleteUsers(UUID id) {
        usersRepository.deleteById(id);
    }

}
