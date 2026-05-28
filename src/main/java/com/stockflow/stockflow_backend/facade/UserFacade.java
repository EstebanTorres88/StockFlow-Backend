package com.stockflow.stockflow_backend.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.UserDto;
import com.stockflow.stockflow_backend.dtos.UserRequestDto;
import com.stockflow.stockflow_backend.mappers.UserMapper;
import com.stockflow.stockflow_backend.services.IUserService;

import jakarta.transaction.Transactional;

@Component
public class UserFacade implements IUserFacade {
  @Autowired
  private IUserService userService;
  
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<UserDto> getAll() {
    return userMapper.toUserDtoList(userService.getAll());
  }

  @Override
  @Transactional
  public UserDto addUser(UserRequestDto userDto) {
    var entity = userService.addUser(userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  public UserDto getByResourceId(UUID resourceId) {
    var entity = userService.getByResourceId(resourceId);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public UserDto updateUser(UUID resourceId, UserRequestDto userDto) {
    var entity = userService.updateUser(resourceId, userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public void removeUser(UUID resourceId) {
    userService.removeUser(resourceId);
  }
}
