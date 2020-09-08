package com.api.modec.manager.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.modec.manager.exception.CodeExistsException;
import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.model.Vessel;
import com.api.modec.manager.repository.EquipmentRepository;
import com.api.modec.manager.repository.VesselRepository;
import com.api.modec.manager.service.ValidateInput;

public class ValidateInput_TEST {

	@InjectMocks
	private ValidateInput validate;

	@Mock
	private EquipmentRepository Equipmentrepository;

	@Mock
	private VesselRepository vesselRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Rule
	public ExpectedException ex = ExpectedException.none();

	@Test
	public void testValidateEquipmentCodeException() {

		Equipment equipment = new Equipment();
		equipment.setCode("rwter122");
		equipment.setLocation("SP");
		equipment.setName("aaaaa");
		equipment.setStatus("active");

		Optional<Equipment> opt = Optional.ofNullable(equipment);
		
		when(Equipmentrepository.findByCode("rwter122")).thenReturn(opt);
		ex.expect(CodeExistsException.class);
		when(validate.validateEquipmentCode("rwter122")).thenReturn(true);

	}

	@Test
	public void testValidateEquipmentCodeTrue() {

		Optional<Equipment> opt = Optional.ofNullable(null);
		when(Equipmentrepository.findByCode("rwter122")).thenReturn(opt);
		assertEquals(true, validate.validateEquipmentCode("rwter122"));
	}

	@Test
	public void testValidVesselCodeInputException() {

		Equipment equipment = new Equipment();

		equipment.setCode("rwter122");
		equipment.setLocation("SP");
		equipment.setName("aaaaa");
		equipment.setStatus("active");
		
		Vessel vesselObject = new Vessel();
		vesselObject.setCdEquipment("5310B9D7");
		vesselObject.setCdVessel("MV102");

		Optional<Vessel> vesselCode = Optional.ofNullable(vesselObject);
		when(vesselRepository.findById("rwter122")).thenReturn(vesselCode);
		ex.expect(CodeExistsException.class);
		validate.validVesselCodeInput("rwter122");

	}

	@Test
	public void testValidVesselCodeInputTrue() {

		Optional<Vessel> vesselCode = Optional.ofNullable(null);
		when(vesselRepository.findById("rwter122")).thenReturn(vesselCode);
		assertEquals(true, validate.validVesselCodeInput("rwter122"));

	}
}
