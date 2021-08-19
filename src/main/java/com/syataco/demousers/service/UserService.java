/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syataco.demousers.service;

import com.syataco.demousers.bean.UserBean;
import com.syataco.demousers.model.User;
import com.syataco.demousers.repository.UserRepository;
import com.syataco.demousers.utils.UserUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saroff
 */
@Service
@Transactional
@Log4j2
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(UserBean userBean) {
        if (userBean != null) {
            User user = new User();
            user.setName(userBean.getName());
            user.setEmail(userBean.getEmail());
            user.setPassword(userBean.getPassword());

            user = userRepository.save(user);
            
            log.info("An user with id={} was created.", user.getId());
            return user;
        }
        log.error("The user cannot was created");
        return null;        
    }
    
    public UserBean getUserById(Long id) {
        if (id != null) {
            Optional<User> optionalUser = userRepository.findById(id);
            if (optionalUser.isPresent()) {
                UserBean userBean = new UserBean();
                userBean.setId(optionalUser.get().getId());
                userBean.setName(optionalUser.get().getName());
                userBean.setEmail(optionalUser.get().getEmail());
                userBean.setPassword(optionalUser.get().getPassword());
                log.info("User: {}", userBean.toString());
                return userBean;
            }
        }
        return null;
    }
    
    public List<UserBean> getAllUsers() {
        List<UserBean> userBeanList = new ArrayList<>();
        userRepository.findAll().forEach(
                element -> userBeanList.add(UserUtils.toBean(element))
        );
        return userBeanList;
    }
    
    public UserBean updateUser(Long id, UserBean userBean) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userBean.getName());
            user.setEmail(userBean.getEmail());
            user.setPassword(userBean.getPassword());
            user = userRepository.save(user);
            log.info("An user with id={} was updated.", user.getId());
            return UserUtils.toBean(user);
        }
        return null;
    }
    
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            userRepository.deleteById(id);
            log.info("An user with id={} was deleted.", id);
        }
    }
    
    public UserBean validateUser(String email, String password) {
        User user = userRepository.getUserByEmailAndPassword(email, password);
        if(user != null){
            log.info("The user whit email={} was logged", user.getEmail());
            return UserUtils.toBean(user);
        }
        return null;
    }
}
