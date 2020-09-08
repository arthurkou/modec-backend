package com.api.modec.manager.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.api.modec.manager.controller.EquipmentController;
import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.repository.EquipmentRepository;
import com.api.modec.manager.service.ValidateInput;

public class EquipmentController_TEST {
	
	@InjectMocks
	private EquipmentController equipmentController;
		
	@Mock
	private EquipmentRepository repository;
	
	@Mock
	private ValidateInput validateInput;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void EquipmentRestController_TEST() {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Equipment equipment = new Equipment();
		equipment.setCode("5310B9D7");
		equipment.setLocation("BRAZIL");
		equipment.setName("compressor");
		equipment.setStatus("active");
		
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(equipment);
		
		when(repository.findAll()).thenReturn(equipmentList);		
		assertNotNull(equipmentController.listAllEquipments());
		
		when(repository.findByStatus("active")).thenReturn(equipmentList);
		assertNotNull(equipmentController.listEquipmentsByStatus("active"));
		
		when(validateInput.validateEquipmentCode("5310B9D7")).thenReturn(true);
		when(repository.save(equipment)).thenReturn(equipment);
		assertNotNull(equipmentController.registerNewEquipment(equipment));
		
		when(repository.save(equipment)).thenReturn(equipment);
		assertNotNull(equipmentController.updateStatus(equipment));
		
	}
}
