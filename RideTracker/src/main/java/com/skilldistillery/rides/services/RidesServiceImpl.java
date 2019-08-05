package com.skilldistillery.rides.services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skilldistillery.rides.entities.Rides;
import com.skilldistillery.rides.repositories.RidesRepository;

@Service
public class RidesServiceImpl implements RidesService {

	@Autowired
	private RidesRepository repo;

	@Override
	public List<Rides> index() {
		return repo.findAll();
	}
	



	@Override
	public Boolean delete(int fid) {
		Boolean deleted = false;
		try {
			repo.deleteById(fid);
			deleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deleted;
	}

	@Override
	public Rides show(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Rides create(Rides ride) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(ride);
	}



	@Override
	public Rides update(int rid, Rides ride) {
		// TODO Auto-generated method stub
		return ride;
	}


}
