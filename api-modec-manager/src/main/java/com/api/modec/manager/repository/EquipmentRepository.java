package com.api.modec.manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.modec.manager.model.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, String>{

	Optional<Equipment> findByCode(String code);
	List<Equipment> findByStatus(String status);
	
}
