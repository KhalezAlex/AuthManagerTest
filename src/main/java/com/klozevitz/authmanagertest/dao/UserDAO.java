package com.klozevitz.authmanagertest.dao;

import com.klozevitz.authmanagertest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
