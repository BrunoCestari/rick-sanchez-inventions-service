package com.bccestari.rick_sanchez_inventions_service.repositories;

import com.bccestari.rick_sanchez_inventions_service.models.Invention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventionsRepository extends JpaRepository<Invention, Integer> {
}
