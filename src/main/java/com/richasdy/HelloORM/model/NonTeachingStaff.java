package com.richasdy.HelloORM.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity

//Inheritence Strategy configuration not mutually bugging

// Inheritence Strategy SINGLE_TABLE configuration
@DiscriminatorValue(value = "NS")

//Inheritence Strategy JOIN configuration
@PrimaryKeyJoinColumn(referencedColumnName="sid")

//Inheritence Strategy TABLE_PER_CLASS no configuration

public class NonTeachingStaff extends Staff {
	private String areaexpertise;

	public NonTeachingStaff(int sid, String sname, String areaexpertise) {
		super(sid, sname);
		this.areaexpertise = areaexpertise;
	}

	public NonTeachingStaff() {
		super();
	}

	public String getAreaexpertise() {
		return areaexpertise;
	}

	public void setAreaexpertise(String areaexpertise) {
		this.areaexpertise = areaexpertise;
	}
}
