package ru.alex.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.alex.data.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
