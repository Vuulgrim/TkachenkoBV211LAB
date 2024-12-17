package org.example.tkachenkoBV211lab.repository;

import org.example.tkachenkoBV211lab.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
