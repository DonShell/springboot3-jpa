package com.donshell.testes.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donshell.testes.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
