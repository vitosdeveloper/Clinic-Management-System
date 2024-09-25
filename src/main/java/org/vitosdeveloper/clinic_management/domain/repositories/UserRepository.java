package org.vitosdeveloper.clinic_management.domain.repositories;

import org.vitosdeveloper.clinic_management.domain.entities.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {
    Optional<User> findByEmail(String email);
}
