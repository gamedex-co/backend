package com.gamedex.backend.auth;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gamedex.backend.user.UserEntity;

public interface AuthRepository extends MongoRepository<UserEntity, String> {
}