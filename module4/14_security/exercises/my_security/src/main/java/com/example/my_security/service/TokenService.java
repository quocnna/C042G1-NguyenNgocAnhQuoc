package com.example.my_security.service;

import com.example.my_security.model.Token;

public interface TokenService {
    Token createToken(Token token);
    Token findByToken(String token);
}
