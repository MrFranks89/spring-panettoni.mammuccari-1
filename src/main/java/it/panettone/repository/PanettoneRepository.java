package it.panettone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.panettone.model.Panettone;

public interface PanettoneRepository extends JpaRepository<Panettone, Long> {
    List<Panettone> findByNomeContaining(String keyword);
}