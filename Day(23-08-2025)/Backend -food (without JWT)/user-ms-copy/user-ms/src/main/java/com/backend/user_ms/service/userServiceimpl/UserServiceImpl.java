package com.backend.user_ms.service.userServiceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.user_ms.entity.User;
import com.backend.user_ms.repository.UserRepository;
import com.backend.user_ms.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        System.out.println("User created");
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            System.out.println("User found with id: " + id);
        } else {
            System.out.println("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public User update(User user) {
        Optional<User> existingUserOpt = userRepository.findById(user.getUserId());

        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            existingUser.setUserName(user.getUserName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserPassword(user.getUserPassword());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + user.getUserId());
        }
    }

    @Override
    public void deleteById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            System.out.println("User deleted with id: " + id);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public User findByEmailAndPassword(String userEmail, String userPassword) {
        return userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
    }
}
