package com.bim.sief.controllers;

import com.bim.sief.services.AuthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bim.sief.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static reactor.core.publisher.Mono.when;

//@SpringBootTest
public class AuthControllerTest {

    @Autowired
    private AuthController authController;
    @MockitoBean
    private AuthService authService;
    @MockitoBean
    private User user;

    private static final String userName = "lmartinez";
    private static final String userPassOk = "12345";
    private static final String userPassBad = "55555";
    private static final boolean userStatusTrue = true;
    private static final boolean userStatusFalse = false;

    User userOk;
    User userBad;
    User userInact;

    @BeforeEach
    public void setUp() {
        userOk = new User();
        userBad = new User();
        userInact = new User();
    }

    //@Test
    void login() {
        //authService.authorize()

        userOk.setName(userName);
        userOk.setPassword(userPassOk);
        userOk.setStatus(userStatusTrue);
        Mockito.when(authService.authorize(userOk)).thenReturn(true);
        Assertions.assertEquals(ResponseEntity.ok("Usuario autorizado"), authController.login(userOk));

        userInact.setName(userName);
        userInact.setPassword(userPassOk);
        userInact.setStatus(userStatusFalse);
        Mockito.when(authService.authorize(userInact)).thenReturn(false);
        Assertions.assertEquals(authController.login(userInact), ResponseEntity.status(403).body("Usuario Inactivo"));


        userBad.setName(userName);
        userBad.setPassword(userPassBad);
        userBad.setStatus(userStatusTrue);
        Mockito.when(authService.authorize(userBad)).thenReturn(null);
        Assertions.assertEquals(authController.login(userBad), ResponseEntity.status(401).body("Usuario no encontrado"));

    }

}
