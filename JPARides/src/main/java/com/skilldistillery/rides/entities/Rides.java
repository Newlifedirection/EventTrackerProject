package com.skilldistillery.rides.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ridescol;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRidescol() {
		return ridescol;
	}
	public void setRidescol(String ridescol) {
		this.ridescol = ridescol;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((ridescol == null) ? 0 : ridescol.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rides other = (Rides) obj;
		if (id != other.id)
			return false;
		if (ridescol == null) {
			if (other.ridescol != null)
				return false;
		} else if (!ridescol.equals(other.ridescol))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Rides [id=").append(id).append(", ridescol=").append(ridescol).append("]");
		return builder.toString();
	}
	public Rides(int id, String ridescol) {
		super();
		this.id = id;
		this.ridescol = ridescol;
	}
	public Rides() {
		super();
	}

}
