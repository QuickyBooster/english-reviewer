package com.quicky.englishreviewer.security.repository;

import com.quicky.englishreviewer.security.model.User;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;


public interface UserRepository extends ListCrudRepository<User,Long> {
    Optional<User>findByUsername(String username);
}
