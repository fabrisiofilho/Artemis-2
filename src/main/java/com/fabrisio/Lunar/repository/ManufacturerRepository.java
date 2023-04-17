package com.fabrisio.Lunar.repository;

import com.fabrisio.Lunar.entity.ManufacturerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, UUID>  {
	
}
