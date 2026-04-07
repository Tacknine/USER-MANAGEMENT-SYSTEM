package com.tacknine.ums.repository;

import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Long id);
    Optional<User> findByAge(Integer age);

}
