package com.arkentos.rocket.repository;

import com.arkentos.rocket.entity.User;
import com.arkentos.rocket.entity.UserPermission;
import com.arkentos.rocket.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPermissionRepository extends JpaRepository<UserPermission, Long> {
    List<UserPermission> findByUserRole(UserRole userRole);


}
