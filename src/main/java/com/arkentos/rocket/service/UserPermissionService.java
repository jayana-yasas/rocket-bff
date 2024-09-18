package com.arkentos.rocket.service;

import com.arkentos.rocket.entity.Task;
import com.arkentos.rocket.entity.User;
import com.arkentos.rocket.entity.UserPermission;
import com.arkentos.rocket.entity.UserRole;
import com.arkentos.rocket.enums.DeletedEnum;
import com.arkentos.rocket.enums.EnabledEnum;
import com.arkentos.rocket.repository.TaskRepository;
import com.arkentos.rocket.repository.UserPermissionRepository;
import com.arkentos.rocket.repository.UserRepository;
import com.arkentos.rocket.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserPermissionService {
    private final TaskRepository taskRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserPermissionRepository userPermissionRepository;

    @Transactional
    public void addTask(String taskName) {
        Task task = taskRepository.findByName(taskName).orElse(null);
        if (Objects.isNull(task)) {
            task = new Task();
            task.setDeleted(DeletedEnum.NO);
            task.setName(taskName);
            task.setSort(0);
            task.setEventName(taskName.toUpperCase().replace(" ", "_"));
            task = taskRepository.save(task);


            Task finalTask = task;
            userRoleRepository.findByDeleted(DeletedEnum.NO).forEach(userRole->{
               savePermission(userRole.getUserRoleId(), finalTask.getTaskId(), EnabledEnum.NO);
            });
        } else {
            throw new RuntimeException("Task already exists");
        }

    }

    @Transactional
    public void savePermission(Long userRoleId, Long taskId, EnabledEnum enabledEnum) {
        UserPermission userPermission = new UserPermission();
        userPermission.setUserRole(userRoleRepository.findById(userRoleId).orElseThrow(() -> new RuntimeException("User role not found")));
        userPermission.setTask(taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found")));
        userPermission.setEnabled(enabledEnum);
        userPermissionRepository.save(userPermission);
    }


    @Transactional
    public void addRole(String roleName) {
        UserRole userRole = userRoleRepository.findByName(roleName).orElse(null);
        if (Objects.isNull(userRole)) {
            userRole = new UserRole();
            userRole.setDeleted(DeletedEnum.NO);
            userRole.setName(roleName);
            userRole.setSort(0);
            userRole = userRoleRepository.save(userRole);


            UserRole finalUserRole = userRole;
            taskRepository.findByDeleted(DeletedEnum.NO).forEach(task->{
                savePermission(finalUserRole.getUserRoleId(), task.getTaskId(), EnabledEnum.NO);
            });
        } else {
            throw new RuntimeException("User role already exists");
        }

    }

    public List<UserPermission> byUserRole(User user) {
        List<UserPermission> userPermissions = new ArrayList<>();

        userPermissionRepository.findByUserRole(user.getUserRole()).forEach(userPermissions::add);

        return userPermissions;
    }
}