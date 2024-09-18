package com.arkentos.rocket.controller;

import com.arkentos.rocket.entity.User;
import com.arkentos.rocket.entity.UserPermission;
import com.arkentos.rocket.service.UserPermissionService;
import com.arkentos.rocket.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("/user-permission")
public class UserPermissionController {

    private final UserPermissionService userPermissionService;

    @GetMapping("/me")
    public ResponseEntity<List<UserPermission>> myPermissions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(userPermissionService.byUserRole(currentUser));
    }

    @PostMapping("/task")
    public ResponseEntity<Object> addTask(@RequestParam String taskName) {
        userPermissionService.addTask(taskName);
        return ResponseEntity.ok("Task Added");
    }

    @PostMapping("/role")
    public ResponseEntity<Object> addRole(@RequestParam String roleName) {
        userPermissionService.addRole(roleName);
        return ResponseEntity.ok("User role added");
    }
}