package com.api.modec.manager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.modec.manager.exception.CodeExistsException;
import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.model.Vessel;
import com.api.modec.manager.repository.EquipmentRepository;
import com.api.modec.manager.repository.VesselRepository;

@Service
public class ValidateInput {

	@Autowired
	private EquipmentRepository equipmentRepository;

	@Autowired
	private VesselRepository vesselRepository;

	public boolean validateEquipmentCode(String code) {

		Optional<Equipment> equipCode = equipmentRepository.findByCode(code);

		if (equipCode.isPresent()) {
			throw new CodeExistsException("This code of EQUIPMENT already exists. You should input a different one!");
		}
		return true;

	}

	public boolean validVesselCodeInput(String cdVessel) {

		Optional<Vessel> vesselCode = vesselRepository.findById(cdVessel);

		if (vesselCode.isPresent()) {
			throw new CodeExistsException("This code of VESSEL already exists. You should input a different one!");
		}

		return true;

	}

}
