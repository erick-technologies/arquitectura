package com.bim.sief.services;

import com.bim.sief.repositories.AuthRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import com.bim.sief.models.User;

import java.util.Optional;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

//@SpringBootTest
class HealtCheckServiceTest {

    @Mock
    AuthRepository authRepository;

    @InjectMocks
    HealtCheckService healtCheckService;


    @BeforeEach
    void setUp() {
        User user = new User();
        user.setName("Ramirez");
        user.setId(123L);
        Mockito.when(authRepository.findByName(anyString())).thenReturn(user);
    }

  //  @Test
    void methodX() {
        String y = healtCheckService.methodX("Prueba");
        Assertions.assertEquals("Ok-Ramirez", y);
    }

    @Test
    void methodXWithException() {
        String y = healtCheckService.methodX("Prueba");
        Assertions.assertEquals("Ok-Ramirez", y);
    }

}