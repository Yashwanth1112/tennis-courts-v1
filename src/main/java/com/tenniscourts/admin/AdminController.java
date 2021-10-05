package com.tenniscourts.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.guests.Guest;

@RestController
@RequestMapping("/guest")
public class AdminController extends BaseRestController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/guestAll")
	public ResponseEntity<List<Guest>> getAllGuests() {
		List<Guest> list = adminService.getAllGuests();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/GuestId/{id}")
	public ResponseEntity<Guest> getAllById(@PathVariable Integer id) {
		Guest guest = adminService.getById(id);
		return ResponseEntity.ok(guest);
	}

	@PostMapping("/guestRegister")
	public ResponseEntity<Guest> registerPatient(@RequestBody Guest guest) {
		adminService.guestRegestration(guest);
		return new ResponseEntity<Guest>(guest, HttpStatus.CREATED);
	}

	@GetMapping("/guestname/{name}")
	public ResponseEntity<Guest> getGuestByName(@PathVariable String name) {
		Guest guest = adminService.getByName(name);
		return new ResponseEntity<Guest>(guest, HttpStatus.OK);
	}

	@PutMapping("/updateguest/{id}")
	public ResponseEntity<Guest> updateGuestById(@PathVariable Integer id, @RequestBody Guest guest) {
		Guest guest1 = adminService.updateGuestById(guest, id);
		return new ResponseEntity<Guest>(guest1, HttpStatus.OK);
	}

	@DeleteMapping("/deleteguestbyid/{id}")
	public ResponseEntity<String> deleteGuestById(@PathVariable Integer id) {
		adminService.deleteGuestById(id);
		return new ResponseEntity<>("GuestDeletedSuccessfully", HttpStatus.OK);

	}
}
