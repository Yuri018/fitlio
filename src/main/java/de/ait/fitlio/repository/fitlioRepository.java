package de.ait.fitlio.repository;

import de.ait.fitlio.model.Fitlio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface fitlioRepository extends JpaRepository<Fitlio, Long> {
}
