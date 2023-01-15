package ru.alex.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.alex.entities.Authority;

@Repository
public interface RoleRepository extends CrudRepository<Authority, Long> {
}
