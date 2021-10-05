package com.tenniscourts.admin;

import java.util.List;

import com.tenniscourts.guests.Guest;

public interface AdminService {
	public void guestRegestration(Guest guest);

	public List<Guest> getAllGuests();

	public Guest getById(Integer id);
	
	public Guest getByName(String name);
	
	public Guest updateGuestById(Guest guest , Integer id );
	
	public void deleteGuestById(Integer id);

}
