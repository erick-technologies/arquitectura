package com.bim.sief.repositories;

import com.bim.sief.models.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface AuthRepository {//extends JpaRepository<User, Long> {

   //User findByName(String name);
   Optional<User> findByNameAndPassword(String name, String password);

}
