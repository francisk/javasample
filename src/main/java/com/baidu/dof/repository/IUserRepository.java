package com.baidu.dof.repository;

import com.baidu.dof.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

    @Query("select t from UserEntity t where t.name = :name")
    UserEntity findByUserName(@Param("name") String name);

    @Query("select t from UserEntity t where t.id = :id")
    UserEntity findUserById(@Param("id") long id);

    @Query("Select t from UserEntity t where t.name = :name and t.email = :email")
    UserEntity findUniqueUser(@Param("name") String name, @Param("email") String email);


}