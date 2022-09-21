package com.sar.contactmicroservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sar.contactmicroservices.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	
//	fake list of contacts
	List<Contact> listOfContacts = List.of(
		new Contact(1, "ankit@gmail.com", "ankit", 1311),
		new Contact(2, "rahul@gmail.com", "rahul", 1231),
		new Contact(3, "aman@gmail.com", "aman", 1321),
		new Contact(4, "ankitsaini@gmail.com", "ankit saini", 1311)
	);

	@Override
	public List<Contact> getContactOfUser(int userId) {
		return listOfContacts.stream().filter(contact -> contact.getUserId()==userId).collect(Collectors.toList());
	}

}
