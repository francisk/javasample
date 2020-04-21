package com.baidu.dof.entity;

import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.baidu.dof.util.Encrypt;
import java.util.Date;
import com.baidu.dof.entity.AbstractEntity;

@Entity
@Table(name = "dbusers")
public class UserEntity extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String password;

    private String email;

    private Date registerTime;

    /* Default constructor,cause id is auto-increment. */
    public UserEntity() {

    }

    public UserEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password) throws Exception{
        this.password = Encrypt.sha1(password);
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Date getRegisterTime(){
        return this.registerTime;
    }

    public void setRegisterTime(Date current){
        this.registerTime = current;
    }
}
