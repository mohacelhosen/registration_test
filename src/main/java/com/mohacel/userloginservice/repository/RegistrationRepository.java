package com.mohacel.userloginservice.repository;

import com.mohacel.userloginservice.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {
}
