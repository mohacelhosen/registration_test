package com.mohacel.userloginservice.service;

import com.mohacel.userloginservice.common.Copy;
import com.mohacel.userloginservice.dto.AddressDto;
import com.mohacel.userloginservice.dto.RegistrationDto;
import com.mohacel.userloginservice.entity.AddressEntity;
import com.mohacel.userloginservice.entity.RegistrationEntity;
import com.mohacel.userloginservice.repository.RegistrationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService implements IUserService {
    Logger logger = LoggerFactory.getLogger(RegistrationService.class);
    @Autowired
    private RegistrationRepository repository;

    @Override
    public RegistrationDto saveUser(RegistrationDto userInfo) {
        Optional<RegistrationEntity> entity = repository.findById(userInfo.getUserId());
        if (entity.isEmpty()) {
            RegistrationEntity registration = new RegistrationEntity();
            Copy.copyNonNullProperties(userInfo, registration);
            logger.info("DTO::" + userInfo.toString());
            logger.info("Entity::" + registration.toString());
            RegistrationEntity save = repository.save(registration);
            logger.info("After save Entity::" + save.toString());
            Copy.copyNonNullProperties(save, userInfo);
            logger.info("After save DTO::" + save.toString());
            return userInfo;
        }
        return null;
    }

    @Override
    public RegistrationDto updateUser(RegistrationDto userInfo) {
        Optional<RegistrationEntity> entity = repository.findById(userInfo.getUserId());
        if (entity.isPresent()) {
            Copy.copyNonNullProperties(userInfo, entity.get());

            AddressEntity addressEntity = entity.get().getAddress();
            AddressDto addressDto = userInfo.getAddress();
            if (addressDto != null) {
                Copy.copyNonNullProperties(addressDto, addressEntity);
            }
            RegistrationEntity updateUserInfo = repository.save(entity.get());
            Copy.copyNonNullProperties(updateUserInfo, userInfo);
            return userInfo;
        }
        return null;
    }

    @Override
    public Boolean deleteUserInfo(Integer userId) {
        Optional<RegistrationEntity> entity = repository.findById(userId);
        if (entity.isPresent()) {
            repository.delete(entity.get());
            return true;
        }
        return false;
    }

    @Override
    public RegistrationDto getUser(Integer userId) {
        Optional<RegistrationEntity> entity = repository.findById(userId);
        if (entity.isPresent()) {
            RegistrationDto registrationDto = new RegistrationDto();
            Copy.copyNonNullProperties(entity, registrationDto);
            return registrationDto;

        }
        return null;
    }

    @Override
    public List<RegistrationDto> getAllUser() {
        List<RegistrationEntity> entityList = repository.findAll();
        List<RegistrationDto> allUserInfo = new ArrayList<>();

        for (RegistrationEntity entity : entityList) {
            RegistrationDto registrationDto = new RegistrationDto();
            Copy.copyNonNullProperties(entity, registrationDto);
            allUserInfo.add(registrationDto);
        }
        return allUserInfo;
    }
}
