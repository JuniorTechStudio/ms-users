package com.jts.subscription.users.repository;

import com.jts.subscription.users.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {

}