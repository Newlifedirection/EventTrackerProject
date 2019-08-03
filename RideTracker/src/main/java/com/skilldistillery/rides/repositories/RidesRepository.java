package com.skilldistillery.rides.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skilldistillery.rides.entities.Rides;

public interface RidesRepository extends JpaRepository<Rides, Integer> {

//	Write a method stub that will find (GET)a ride by its name.
	List<Rides> findByName(String name);
	
//	Write a method stub that will find (GET) all rides.
	List<Rides> findAll();
	
//	Write a method stub that will update (PUT) a ride.
//	List<Rides> updateRide(String name);
	

}
