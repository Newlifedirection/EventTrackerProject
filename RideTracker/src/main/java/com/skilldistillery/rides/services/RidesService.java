package com.skilldistillery.rides.services;

import java.util.List;

import com.skilldistillery.rides.entities.Rides;

public interface RidesService {
	
	List<Rides> index();
	Rides show(int id);
	Rides create(Rides rede);
	Rides update(int rid, Rides ride);
	Boolean delete(int rid);

	
}
