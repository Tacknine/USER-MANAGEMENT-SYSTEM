package com.tacknine.ums.repository;

import com.tacknine.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ScopedValue;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Long id);
    Optional<User> findByAge(Integer age);
    Optional<User> findByEmail(String email);


}
