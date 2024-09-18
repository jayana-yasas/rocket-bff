package com.arkentos.rocket.repository;

import com.arkentos.rocket.entity.Task;
import com.arkentos.rocket.entity.UserPermission;
import com.arkentos.rocket.entity.UserRole;
import com.arkentos.rocket.enums.DeletedEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByName(String name);

    List<Task> findByDeleted(DeletedEnum deleted);


}
