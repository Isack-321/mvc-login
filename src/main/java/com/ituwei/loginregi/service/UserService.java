package com.ituwei.loginregi.service;

import com.ituwei.loginregi.model.User;

public interface UserService {
        void save(User user);

        User findByUsername(String username);
    }

