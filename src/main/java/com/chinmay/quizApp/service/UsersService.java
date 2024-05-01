package com.chinmay.quizApp.service;

import java.util.List;

import com.chinmay.quizApp.model.Users;



public interface UsersService {
	Users saveUser(Users user);
	List<Users> getAllUsers();
	Users updateUser(Users user, long id);
	void deleteUser(String email);
	Users getUserById(String email);
	void updateProduct(String email, String newName, double newPassword);
	boolean validateUser(String email, String password);
}
