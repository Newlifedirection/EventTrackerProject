package com.skilldistillery.rides.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.rides.entities.Rides;
import com.skilldistillery.rides.services.RidesService;

@RestController
@RequestMapping("api")
public class RidesController {


	@Autowired
	private RidesService svc;

	@GetMapping("rides")
	public List<Rides> index() {

		return svc.index();
	}

	@GetMapping("rides/{rid}")
	public Rides getRide(@PathVariable("rid") Integer rideId, 
			HttpServletResponse resp) 
	{

		return svc.show(rideId);

	}

	// TODO PostMapping for new ride
	@PostMapping("rides")
	public Rides createRide(@RequestBody Rides ride) 
//			HttpServletRequest req,
//			HttpServletResponse resp)
	{
		return svc.create(ride);
	}
	
	// TODO PutMapping replace ride
	@PutMapping("rides/{rid}")
	public Rides replaceRide(@PathVariable("rid") Integer rideId,
			@RequestBody Rides ride,
			HttpServletRequest req,
			HttpServletResponse resp) 
	{
		ride = svc.update(rideId, ride);
			if (ride == null) {
				resp.setStatus(404);
			}
			if (ride != null) {
				resp.setStatus(200);
			}
			return svc.update(rideId, ride);
	}
	
	// TODO PutMapping replace ride
//	@PutMapping("rides/{rid}")
//	public Rides replaceRide(@PathVariable("rid") Integer rideId, 
//			@RequestBody Rides ride, 
//		HttpServletRequest req,
//		HttpServletResponse resp)
//	{
//		ride = svc.update(rideId, ride);
//		if (ride == null) {
//			resp.setStatus(404);
//		}
//		return ride;
//
//	}
	
	// TODO DeleteMapping ride by id
	@DeleteMapping("rides/{rid}")
	public Boolean deleteRideById(@PathVariable("rid")Integer rid) {
		
			svc.delete(rid);
		return true;
	}
	

}
