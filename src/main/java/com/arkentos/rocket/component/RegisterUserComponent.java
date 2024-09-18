package com.arkentos.rocket.component;

// UserService.java
import com.arkentos.rocket.entity.User;
import com.arkentos.rocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
    public class RegisterUserComponent{
        @Autowired
        private UserRepository userRepository;

        private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        public User registerUser(String username, String password) {
            User user = userRepository.findByEmail(username).orElse(new User());

            if(Objects.isNull(user.getPassword())){
                user.setPassword(passwordEncoder.encode(password)); // Hashing the password
                return userRepository.save(user);
            }else {
                if(passwordEncoder.encode(password).equals(user.getPassword())){
                    return user;
                }else {
                    return null;
                }
            }



        }

        public User findByUsername(String email) {
            return userRepository.findByEmail(email).orElse(null);
        }


    }