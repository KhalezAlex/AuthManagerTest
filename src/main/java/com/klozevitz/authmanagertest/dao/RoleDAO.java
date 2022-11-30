package com.klozevitz.authmanagertest.dao;

import com.klozevitz.authmanagertest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
