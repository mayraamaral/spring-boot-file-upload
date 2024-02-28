package dev.mayra.file.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.mayra.file.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
