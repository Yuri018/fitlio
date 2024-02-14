package de.ait.fitlio.repository;

import de.ait.fitlio.model.Fitlio;
import de.ait.fitlio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FitlioRepository extends JpaRepository<Fitlio, Long> {

}
