package com.bim.sief.services;

import com.bim.sief.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealtCheckService {

   // @Autowired
    //AuthRepository authRepository;

    public String methodX(String var1){
       // com.bim.sief.models.User user = authRepository.findByName(var1);
        return "Ok-";// + user.getName();
    }
}
