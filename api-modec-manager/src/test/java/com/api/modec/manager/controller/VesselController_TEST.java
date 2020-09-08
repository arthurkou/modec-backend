package com.api.modec.manager.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.api.modec.manager.controller.VesselController;
import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.model.Vessel;
import com.api.modec.manager.repository.VesselRepository;
import com.api.modec.manager.service.ValidateInput;

public class VesselController_TEST {
	
	@InjectMocks
	private VesselController vesselController;
		
	@Mock
	private VesselRepository repository;
	
	@Mock
	private ValidateInput validateInput;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void listAllVessels_TEST() {
		
		Vessel vesselObject = new Vessel();
		vesselObject.setCdEquipment("5310B9D7");
		vesselObject.setCdVessel("MV102");
		
		List<Vessel> vesselList = new ArrayList<Vessel>();
		vesselList.add(vesselObject);
		
		when(repository.findAll()).thenReturn(vesselList);
		assertNotNull(vesselController.listAllVessels());
	}
	
	@Test
	public void registerNewVessel_TEST() {
		
		Vessel vesselObject = new Vessel();
		vesselObject.setCdEquipment("5310B9D7");
		vesselObject.setCdVessel("MV102");
		
		Equipment equipment = new Equipment();
		equipment.setCode("5310B9D7");
		equipment.setLocation("BRAZIL");
		equipment.setName("compressor");
		equipment.setStatus("active");
		
		when(repository.save(vesselObject)).thenReturn(vesselObject);
		assertNotNull(vesselController.registerNewVessel(vesselObject, equipment));
	}

}
