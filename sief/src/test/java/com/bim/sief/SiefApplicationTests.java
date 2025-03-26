package com.bim.sief;

import com.bim.sief.controllers.AuthController;
import com.bim.sief.services.AuthService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mockito;
import com.bim.sief.model.User;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SiefApplicationTests {

<<<<<<< Updated upstream
	@Test
	void contextLoads() {
	}
=======
    /*private AuthController authController;
    private AuthService authService;*/
    private User user;

    @BeforeEach
    public void setUp() {
     /*   authController = new AuthController();
        authService = new AuthService();*/
        user = new User();
    }

    //@Test
    void contextLoads() {
        //************Crean los usuarios
        //usuario ok
        User userOk = new User();
        userOk.setName("lmartinez");
        userOk.setPassword("12345");
        userOk.setStatus(true);

        //authService.authorize(user);
        //Mockito.when(authController.login(userOk)).thenReturn(ResponseEntity.ok("Usuario autorizado"));
        //authController.login(userOk);


        //usuario bad credentials
        User userBad = new User();
        userOk.setName("lmartinez");
        userOk.setPassword("1234512345");
        userOk.setStatus(true);
        //authService.authorize(user);
//        Mockito.when(authController.login(userBad)).thenReturn(ResponseEntity.status(401).body("Usuario no autorizado"));

        //usuario inactivo
        User userInact = new User();
        userOk.setName("lmartinez");
        userOk.setPassword("12345");
        userOk.setStatus(false);
        //authService.authorize(user);
       // Mockito.when(authController.login(userInact)).thenReturn(ResponseEntity.status(403).body("Usuario Inactivo"));

    }
>>>>>>> Stashed changes

}
