/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syataco.demousers.bean;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Saroff
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserBean implements Serializable {
    
    @Expose
    private Long id;
    
    @Expose
    private String name;
    
    @Expose
    private String email;
    
    @Expose
    private String password;

}
