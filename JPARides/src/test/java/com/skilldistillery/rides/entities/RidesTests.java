package com.skilldistillery.rides.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.rides.entities.Rides;

class RidesTests {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rides rides;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("RidesPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em= emf.createEntityManager();
		rides = em.find(rides.getClass(), 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		rides = null;
	}

	@Test
	void test_entity_mappings() {
		assertNotNull(rides);
		assertEquals("Hello", rides.getRidescol());
		fail("Not yet implemented");
	}

}
