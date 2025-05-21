package org.springframework.samples.petclinic.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.samples.petclinic.owner.Pet;

@Entity
public class PetDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	private String temperament;
	private double length;
	private double weight;

	public String getTemperament() {
		return temperament;
	}

	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
