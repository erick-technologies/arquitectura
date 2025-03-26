package com.bim.sief.controllers;

import com.bim.sief.models.User;
import com.bim.sief.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bim.sief.utils.JwtUtils;
import com.bim.sief.utils.JSONUtils;

@Slf4j
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated User user) {
        User isAuthorized = authService.authorize(user);

        if(isAuthorized==null){
            return ResponseEntity.status(401).body("Usuario no encontrado");
        }

        if (!isAuthorized.isStatus()) {
            return ResponseEntity.status(403).body("Usuario Inactivo");
        } else {
            String JWT = generateJWT(isAuthorized);
            log.info("AuthJWT: " + JWT);
            return ResponseEntity.ok(JSONUtils.responseGeneratorJSON(false,"Usuario Admitido",JWT,isAuthorized.getRole()));
        }

    }

    public String generateJWT(User user){
        return JwtUtils.generateToken(user);
    }

    public Boolean validateJWT(String name){
        return JwtUtils.validateToken(name);
    }

}
