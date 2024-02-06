package de.ait.fitlio.repository;

import de.ait.fitlio.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
