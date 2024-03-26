package com.gamedex.backend.user;

import java.util.List;

public interface UserService {

    public List<UserEntity> getUsers() throws Exception;

    public UserEntity getUser(String userId) throws Exception;

    public UserEntity getUserByUsername(String username) throws Exception;
}
