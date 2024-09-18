package com.arkentos.rocket.repository;

import com.arkentos.rocket.entity.Task;
import com.arkentos.rocket.entity.UserRole;
import com.arkentos.rocket.enums.DeletedEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByDeleted(DeletedEnum deleted);

    Optional<UserRole> findByName(String name);
 

}
