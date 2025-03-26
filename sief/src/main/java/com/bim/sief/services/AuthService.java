package com.bim.sief.services;

import com.bim.sief.models.User;
import com.bim.sief.repositories.AuthRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Data
@Service
public class AuthService {

    //@Autowired
    //AuthRepository authRepository;

        public User authorize(User user) {
            //Optional<User> userFound = authRepository.findByNameAndPassword(user.getName(), user.getPassword());

            //Crea base temporal
            List<User> baseTemp = new ArrayList<>();
            User EJAF = new User(1L,"jmartinez","12345","EJAF",true);
            User GEAF = new User(1L,"sramirez","12345","GEAF",true);
            User GTLF = new User(1L,"GTLF","12345","GTLF",true);
            User STLF = new User(1L,"STLF","12345","STLF",true);
            User DICF = new User(1L,"DICF","12345","DICF",true);
            User DIGE = new User(1L,"DIGE","12345","DIGE",true);
            User ELMC = new User(1L,"ELMC","12345","ELMC",true);
            User EAFC = new User(1L,"EAFC","12345","EAFC",true);
            User ADMI = new User(1L,"ADMI","12345","ADMI",true);
            User CLIE = new User(1L,"CLIE","12345","CLIE",true);

            baseTemp.add(EJAF);
            baseTemp.add(GEAF);
            baseTemp.add(GTLF);
            baseTemp.add(STLF);
            baseTemp.add(DICF);
            baseTemp.add(DIGE);
            baseTemp.add(ELMC);
            baseTemp.add(EAFC);
            baseTemp.add(ADMI);
            baseTemp.add(CLIE);

            Optional<User> userFound =
                    baseTemp.stream()
                            .filter(user1 -> user1.getName().equals(user.getName()))
                            .findAny();

            if (userFound.isPresent()) {
                // desencriptar conseña
                log.info(userFound.get().getRole());
                if(userFound.get().isStatus()){
                    return userFound.get();
                }else {
                    return userFound.get();
                }

            }
            return null;
        }

}
