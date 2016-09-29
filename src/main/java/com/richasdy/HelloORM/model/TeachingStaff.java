package com.richasdy.HelloORM.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity

//Inheritence Strategy configuration not mutually bugging

//Inheritence Strategy SINGLE_TABLE configuration
@DiscriminatorValue(value = "TS")

//Inheritence Strategy JOIN configuration
@PrimaryKeyJoinColumn(referencedColumnName="sid")

//Inheritence Strategy TABLE_PER_CLASS no configuration

public class TeachingStaff extends Staff {
	private String qualification;
	private String subjectexpertise;

	public TeachingStaff(int sid, String sname,

			String qualification, String subjectexpertise) {
		super(sid, sname);
		this.qualification = qualification;
		this.subjectexpertise = subjectexpertise;
	}

	public TeachingStaff() {
		super();
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSubjectexpertise() {
		return subjectexpertise;
	}

	public void setSubjectexpertise(String subjectexpertise) {
		this.subjectexpertise = subjectexpertise;
	}
}
