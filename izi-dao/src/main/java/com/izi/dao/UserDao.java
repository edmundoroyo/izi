package com.izi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.izi.domain.User;

public interface UserDao extends JpaRepository<User,Long>{

}
