package com.test.danstest.service;

import com.test.danstest.model.User;
import com.test.danstest.model.dto.LoginDTO;
import com.test.danstest.repository.UserRepository;
import com.test.danstest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;

    public ResponseEntity<Object> login(LoginDTO loginDTO){
        Optional<User> optionalUser = userRepository.findByUsername(loginDTO.username);

        //validasi username
        if(optionalUser.isEmpty()){
            return ResponseEntity.badRequest().body(Map.of("message", "USER_NOT_FOUND"));
        }
        User user = optionalUser.get();
        //validasi password
        if(!user.getPassword().equals(loginDTO.password)){
            return ResponseEntity.badRequest().body(Map.of("message", "WRONG_PASSWORD"));
        }

        return ResponseEntity.ok(Map.of("token", JwtUtil.generateToken(user)));
    }
}
