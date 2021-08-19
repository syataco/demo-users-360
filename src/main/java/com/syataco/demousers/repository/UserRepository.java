/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syataco.demousers.repository;

import com.syataco.demousers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Saroff
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query(value="SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
