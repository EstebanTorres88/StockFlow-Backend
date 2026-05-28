package com.stockflow.stockflow_backend.services;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.UserRequestDto;
import com.stockflow.stockflow_backend.entities.User;

public interface IUserService {
  List<User> getAll();  
  User addUser(UserRequestDto userDto);
  User getByResourceId(UUID resourceId);
  User updateUser(UUID resourceId, UserRequestDto userDto);
  void removeUser(UUID resourceId);
}
