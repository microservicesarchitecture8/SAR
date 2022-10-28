package com.sar.contactmicroservices.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sar.contactmicroservices.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{
	
	private Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	
//	list of contacts
	List<Contact> listOfContacts = List.of(
		new Contact(1, "shubhangi@gmail.com", "Shubhangi", 1001),
		new Contact(2, "devangi@gmail.com", "Devangi", 1002),
		new Contact(3, "ankita@gmail.com", "Ankita", 1003),
		new Contact(4,"snehal@gmail.com","Snehal",1004),
		new Contact(5, "apurva@gmail.com", "Apurva", 1005)
	);

	@Override
	public List<Contact> getContactOfUser(int contactId) {
		logger.info("ContactServiceImpl getContactOfUser method called");
		return listOfContacts.stream().filter(contact -> contact.getUserId()==contactId).collect(Collectors.toList());
	}
	
	@Override
	public List<Contact> getAllContacts() {
		logger.info("ContactServiceImpl getAllContacts method called");
		return listOfContacts;
	}
	
	@Override
	public List<Contact> deleteContactOfUser(int contactId) {
		logger.info("ContactServiceImpl deleteContactOfUser method called");
		listOfContacts = listOfContacts.stream()
				.filter(contact -> contact.getUserId()!=contactId)
				.collect(Collectors.toList());
		return listOfContacts;
	}

}
