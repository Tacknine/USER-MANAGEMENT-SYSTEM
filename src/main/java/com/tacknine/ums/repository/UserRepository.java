package com.tacknine.ums.repository;

import com.tacknine.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
