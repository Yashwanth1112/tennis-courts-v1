package com.tenniscourts.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenniscourts.guests.Guest;

@Repository
public interface AdminRepository extends JpaRepository<Guest, Integer> {
 
	Guest findByName(String name);
	
}
