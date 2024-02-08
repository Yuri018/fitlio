package de.ait.fitlio.repository;

import de.ait.fitlio.model.Fitlio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FitlioRepository extends JpaRepository<Fitlio, Long> {
}
