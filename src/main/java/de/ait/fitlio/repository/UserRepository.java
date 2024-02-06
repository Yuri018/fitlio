package de.ait.fitlio.repository;

import de.ait.fitlio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
