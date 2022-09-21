package com.sar.contactmicroservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sar.contactmicroservices.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	
//	fake list of contacts
	List<Contact> listOfContacts = List.of(
		new Contact(1, "shubhangi@gmail.com", "Shubhangi", 1001),
		new Contact(2, "devangi@gmail.com", "Devangi", 1002),
		new Contact(3, "ankita@gmail.com", "Ankita", 1003),
		new Contact(4,"snehal@gmail.com","Snehal",1004),
		new Contact(5, "apurva@gmail.com", "Apurva", 1005)
	);

	@Override
	public List<Contact> getContactOfUser(int userId) {
		return listOfContacts.stream().filter(contact -> contact.getUserId()==userId).collect(Collectors.toList());
	}

}
