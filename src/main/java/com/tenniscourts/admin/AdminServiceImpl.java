package com.tenniscourts.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tenniscourts.guests.Guest;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<Guest> getAllGuests() {
		return adminRepository.findAll();
	}

	@Override
	public Guest getById(Integer id) {
		Optional<Guest> optionalOp = adminRepository.findById(id);
		if (optionalOp.isPresent()) {
			return optionalOp.get();
		}
		return null;
	}

	@Override
	public void guestRegestration(Guest guest) {
		adminRepository.save(guest);
	}

	@Override
	public Guest getByName(String name) {
	Guest guest= adminRepository.findByName(name);
		
		return guest;
	}

	@Override
	public Guest updateGuestById(Guest guest, Integer id) {
		Optional<Guest> optionalOp = adminRepository.findById(id);
		if (optionalOp.isPresent()) {
			return optionalOp.get();
		}
		Guest g = new Guest();
		g.setName(guest.getName());
		
		return g;
	}

	@Override
	public void deleteGuestById(Integer id) {
		adminRepository.deleteById(id);
	}

}
