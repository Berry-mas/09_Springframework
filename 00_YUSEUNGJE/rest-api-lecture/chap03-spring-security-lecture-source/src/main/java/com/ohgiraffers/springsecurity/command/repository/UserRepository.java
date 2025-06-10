package com.ohgiraffers.springsecurity.command.repository;

import com.ohgiraffers.springsecurity.command.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
