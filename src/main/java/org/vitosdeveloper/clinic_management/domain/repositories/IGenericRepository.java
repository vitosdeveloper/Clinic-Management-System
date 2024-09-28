package org.vitosdeveloper.clinic_management.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface IGenericRepository<Entity> {
    Optional<Entity> findById(Long id);

    List<Entity> findAll();

    Entity save(Entity entity);

    void delete(Long id);
}
