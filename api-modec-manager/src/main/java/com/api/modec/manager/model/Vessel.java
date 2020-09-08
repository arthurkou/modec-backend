package com.api.modec.manager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Vessel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String cdVessel;
	private String cdEquipment;

	public String getCdVessel() {
		return cdVessel;
	}

	public void setCdVessel(String cdVessel) {
		this.cdVessel = cdVessel;
	}

	public String getCdEquipment() {
		return cdEquipment;
	}

	public void setCdEquipment(String cdEquipment) {
		this.cdEquipment = cdEquipment;
	}

}
