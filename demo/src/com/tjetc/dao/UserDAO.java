package com.tjetc.dao;

import java.util.List;

import com.tjetc.domain.User;

public interface UserDAO {
   List<User> findAll();
   User  findById(int id);
   void  deleteById(int id);
   void  insertUser(User user);
   void  updateById(User user);
}
