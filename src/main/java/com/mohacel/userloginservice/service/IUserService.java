package com.mohacel.userloginservice.service;

import com.mohacel.userloginservice.dto.RegistrationDto;

import java.util.List;

public interface IUserService
{
    RegistrationDto saveUser(RegistrationDto userInfo);
    RegistrationDto updateUser(RegistrationDto userInfo);
    Boolean deleteUserInfo(Integer userId);
    RegistrationDto getUser(Integer userId);
    List<RegistrationDto> getAllUser();
}
