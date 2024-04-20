package ru.pasvitas.teaching.lessonThree.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pasvitas.teaching.lessonThree.model.UserRole;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
}
