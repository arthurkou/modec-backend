package com.api.modec.manager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.api.modec.manager.model.Equipment;

public class Equipment_TEST {

	@Test
	public void equipmentTest() {
		
		Equipment equip = new Equipment();
		equip.setCode("5310B9D7");
		equip.setLocation("SP");
		equip.setName("compressor");
		equip.setStatus("active");
		
		assertEquals("5310B9D7", equip.getCode());
		assertEquals("SP", equip.getLocation());
		assertEquals("compressor", equip.getName());
		assertEquals("active", equip.getStatus());
		
	}
}
