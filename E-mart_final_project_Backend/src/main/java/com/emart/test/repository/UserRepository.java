package com.emart.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emart.test.entity.User;

public interface UserRepository extends JpaRepository<User,String>{

}
