package com.example.my_security.service;

import com.example.my_security.model.User;
import com.example.my_security.model.UserPrincipal;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
