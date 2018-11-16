package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.List;

public interface UserService {
   List<User> querAll();
   boolean deleteUser(int id);
   boolean updateUser(User user);
   boolean addUser(User user);
   User getUserById(int id);
}
