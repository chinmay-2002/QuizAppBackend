package com.chinmay.quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinmay.quizApp.model.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
