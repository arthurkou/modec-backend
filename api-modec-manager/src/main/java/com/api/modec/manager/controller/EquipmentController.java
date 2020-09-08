package com.api.modec.manager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.model.Vessel;
import com.api.modec.manager.repository.EquipmentRepository;
import com.api.modec.manager.repository.VesselRepository;
import com.api.modec.manager.service.ValidateInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "equipment")
@Api(value = "API Equipments Management")
@CrossOrigin(origins = "*")
public class EquipmentController {

	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@Autowired
	private ValidateInput validator;

	/**
	 * List all equipments registered
	 */
	@ApiOperation(value = "LIST ALL EQUIPMENTS REGISTERED")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Equipment> listAllEquipments() {

		return equipmentRepository.findAll();
	}
	
	
	/**
	 * @param status 
	 * show all equipments filtered by status (active or inactive)
	 */
	@ApiOperation(value = "SHOW ALL EQUIPMENT FILTERED BY STATUS")
	@RequestMapping(value = "/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Equipment> listEquipmentsByStatus(@PathVariable(value = "status") String status) {

		return equipmentRepository.findByStatus(status);
	}

	/**
	 * @param equipment 
	 * register a new equipment and validate if code is valid
	 */
	@ApiOperation(value = "REGISTER A NEW EQUIPMENT")
	@RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Equipment registerNewEquipment(@RequestBody Equipment equipment) {

		boolean validEquipmentCode = validator.validateEquipmentCode(equipment.getCode());

		if (validEquipmentCode == true && equipment.getStatus() == null) {
			equipment.setStatus("active");
		}
		
		return equipmentRepository.save(equipment);
	}	
	
	
	/**
	 * @param equipment 
	 * Update status - setting to inactive
	 */
	@ApiOperation(value = "UPDATE EQUIPMENT'S DATA")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Equipment updateStatus(@RequestBody Equipment equipment) {

		return equipmentRepository.save(equipment);
	}
	

}
