/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syataco.demousers.utils;

import com.syataco.demousers.bean.UserBean;
import com.syataco.demousers.model.User;

/**
 *
 * @author Saroff
 */
public class UserUtils {
    
    public static UserBean toBean(User user) {
        if (user != null) {
            UserBean userBean = new UserBean();
            userBean.setId(user.getId());
            userBean.setName(user.getName());
            userBean.setEmail(user.getEmail());
            userBean.setPassword(user.getPassword());           
           
            return userBean;
        }
        return null;
    }
    
}
