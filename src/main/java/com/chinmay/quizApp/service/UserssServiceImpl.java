package com.chinmay.quizApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinmay.quizApp.exception.ResourceNotFoundException;
import com.chinmay.quizApp.model.Users;
import com.chinmay.quizApp.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UserssServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users saveUser(Users user) {
		return usersRepository.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return usersRepository.findAll();
	}



	@Override
	public Users updateUser(Users user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String email) {
		usersRepository.deleteById(email);
		System.out.println("Deleted " + email);
		
	}

	@Override
	public Users getUserById(String email) {
		return usersRepository.findById(email).orElseThrow(() -> 
	 	new ResourceNotFoundException("User", "Id", email));
	}
	
	@Transactional
	@Override
	public void updateProduct(String email, String newName, double newPassword) {
		// TODO Auto-generated method stub
Optional<Users> optionalProduct = usersRepository.findById(email);
        
        if (optionalProduct.isPresent()) {
            Users user = optionalProduct.get();
            user.setName(newName);
            user.setPassword(newName);
            usersRepository.save(user);
        } else {
            // Handle the case when the product with given ID is not found
            throw new IllegalArgumentException("Email with ID " + email + " not found.");
        }
	}

	@Override
	public boolean validateUser(String email, String password) {
		Optional<Users> optionalUser = usersRepository.findById(email);
        
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            return user.getPassword().equals(password);
        } else {
            return false; // User not found
        }
	}

}
