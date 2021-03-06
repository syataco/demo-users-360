/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syataco.demousers.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Saroff
 */
@Entity
@Table(name="APP_USERS")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of={"id"}, callSuper=false)
public class User implements Serializable {

    @Id
    @Expose
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APP_USERS_SEQ")
    @SequenceGenerator(sequenceName="APP_USERS_SEQ", allocationSize=1, name="APP_USERS_SEQ")
    private Long id;
    
    @Expose
    @Column(name="USER_NAME")
    private String name;
    
    @Expose
    @Column(name="USER_EMAIL")
    private String email;
    
    @Expose
    @Column(name="USER_PASSWORD")
    private String password;
    
}
