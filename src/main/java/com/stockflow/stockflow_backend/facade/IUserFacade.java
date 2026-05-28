package com.stockflow.stockflow_backend.facade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.UserDto;
import com.stockflow.stockflow_backend.dtos.UserRequestDto;

public interface IUserFacade {
  List<UserDto> getAll();  
  UserDto addUser(UserRequestDto userDto);
  UserDto getByResourceId(UUID resourceId);
  UserDto updateUser(UUID resourceId, UserRequestDto userDto);
  void removeUser(UUID resourceId);
}
