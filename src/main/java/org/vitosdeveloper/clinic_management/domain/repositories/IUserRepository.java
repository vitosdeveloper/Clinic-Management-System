package org.vitosdeveloper.clinic_management.domain.repositories;

import org.vitosdeveloper.clinic_management.domain.entities.User;

import java.util.Optional;

public interface IUserRepository extends IGenericRepository<User> {
    Optional<User> findByEmail(String email);
}
