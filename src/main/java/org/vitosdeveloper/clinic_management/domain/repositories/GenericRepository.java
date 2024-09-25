package org.vitosdeveloper.clinic_management.domain.repositories;

import org.vitosdeveloper.clinic_management.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<Entity> {
    Optional<Entity> findById(Long id);

    List<Entity> findAll();

    Entity save(Entity entity);

    void delete(Long id);
}
