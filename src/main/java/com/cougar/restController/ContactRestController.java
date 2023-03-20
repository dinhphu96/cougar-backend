package com.cougar.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.Contact;
import com.cougar.payload.response.MessageResponse;
import com.cougar.service.ContactService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {
	@Autowired ContactService contactService;
	
	@GetMapping("")
	public List<Contact> getAll() {
		return contactService.findAll();
	}
	
	@PostMapping("")
	public ResponseEntity<?> postContact(@RequestBody Contact contact) {
		try {
			contactService.save(contact);
			return ResponseEntity.ok().body(new MessageResponse("Successfully, we will respond to your email as soon as possible!"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new MessageResponse("Failed, please try again later. Sorry for the inconvenience!"));
		}
	}
}