package com.example.punchclock.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.punchclock.model.User;
import com.example.punchclock.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWTController {
    UserService userService;

    @Autowired
    public JWTController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loggin")
    public ResponseEntity loggin(@RequestBody User user) {
        if(userService.findUser(user)) {
            String secret = "123@abc";
            Algorithm algorithm = Algorithm.HMAC512(secret);
            String token = JWT.create()
                    .withIssuer("M223")
                    .withClaim("username", user.getUsername())
                    .withClaim("password", user.getPassword())
                    .sign(algorithm);

            return new ResponseEntity(token, HttpStatus.OK);
        }else {
            return new ResponseEntity("user dosn't exist", HttpStatus.BAD_REQUEST);
        }

    }


}
