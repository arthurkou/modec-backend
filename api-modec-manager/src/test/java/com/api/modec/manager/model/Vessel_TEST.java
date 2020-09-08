package com.api.modec.manager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.api.modec.manager.model.Vessel;

public class Vessel_TEST {
	
	@Test
	public void vesselTest() {
		
		Vessel vesselObject = new Vessel();
		vesselObject.setCdEquipment("5310B9D7");
		vesselObject.setCdVessel("MV102");
		
		assertEquals("5310B9D7", vesselObject.getCdEquipment());
		assertEquals("MV102", vesselObject.getCdVessel());
	}

}
