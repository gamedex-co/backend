package com.gamedex.backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUsers() throws Exception {
        List<UserEntity> users = userRepository.findAll();

        if (users != null) {
            return users;
        }

        throw new Exception("Users not found");
    }

    @Override
    public UserEntity getUser(String userId) throws Exception {
        UserEntity user = userRepository.findById(userId).get();

        if (user != null) {
            return user;
        }

        throw new Exception("User not found");
    }

}
