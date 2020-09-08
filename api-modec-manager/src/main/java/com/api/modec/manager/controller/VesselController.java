package com.api.modec.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.modec.manager.model.Equipment;
import com.api.modec.manager.model.Vessel;
import com.api.modec.manager.repository.VesselRepository;
import com.api.modec.manager.service.ValidateInput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "vessel")
@Api(value = "API Equipments Management")
@CrossOrigin(origins = "*")
public class VesselController {
	
	@Autowired
	private VesselRepository vesselRepository;
	
	@Autowired
	private ValidateInput validator;
	
	/**
	 * List all vessels registered
	 */
	@ApiOperation(value = "LIST ALL VESSELS REGISTERED")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vessel> listAllVessels() {

		return vesselRepository.findAll();
	}
	
	/**
	 * @param vessel
	 * REGISTER NEW VESSEL
	 */
	@ApiOperation(value = "REGISTER A NEW VESSEL")
	@RequestMapping(value = "/new", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Vessel registerNewVessel(@RequestBody Vessel vessel, Equipment equipment) {

		validator.validVesselCodeInput(vessel.getCdVessel());
		
		return vesselRepository.save(vessel);
	}

}
