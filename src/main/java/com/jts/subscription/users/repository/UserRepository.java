package com.jts.subscription.users.repository;

import com.jts.subscription.users.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByTelegramId(String id);
    boolean existsUsersByTelegramId(String id);
}