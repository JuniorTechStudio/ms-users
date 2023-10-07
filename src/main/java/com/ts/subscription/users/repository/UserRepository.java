package com.ts.subscription.users.repository;

import com.ts.subscription.users.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findUserByTelegramId(String id);
    boolean existsUsersByTelegramId(String id);
}