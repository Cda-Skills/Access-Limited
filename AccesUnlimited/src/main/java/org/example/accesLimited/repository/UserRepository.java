package org.example.accesLimited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.accesLimited.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}