package com.ituwei.loginregi.service;

import java.util.HashSet;

import com.ituwei.loginregi.model.User;
import com.ituwei.loginregi.repository.RoleRepository;
import com.ituwei.loginregi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private RoleRepository roleRepository;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        public void save(User user) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRoles(new HashSet<>(roleRepository.findAll()));
            userRepository.save(user);
        }

        @Override
        public User findByUsername(String username) {
            return userRepository.findByUsername(username);
        }
    }

