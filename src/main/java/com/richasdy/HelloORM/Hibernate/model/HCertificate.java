package com.richasdy.HelloORM.Hibernate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hcertificate")
public class HCertificate implements Serializable{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "certificate_name")
	private String name;

	public HCertificate() {}

	public HCertificate(String name) {
	      this.name = name;
	   }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		HCertificate obj2 = (HCertificate) obj;
		if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + name).hashCode();
		return tmp;
	}
}
