package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;

@Service("contactServiceImpl")

public class ContactServiceImpl implements ContactService {
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contactEntity = contactRepository.save(contactConverter.convertContactModelToContactEntity(contactModel));
		return contactConverter.convertContactToContactModel(contactEntity);
		
	}

	@Override
	public List<ContactModel> listContactModel() {
		List<ContactModel> listContactModel = new ArrayList<>();
		List<Contact> listContactEntity = contactRepository.findAll();
			for (Contact contact : listContactEntity) {
				listContactModel.add(contactConverter.convertContactToContactModel(contact));
			}
		return listContactModel;
	}
	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContactToContactModel(contactRepository.findById(id));
	}

	@Override
	public void deleteContact(int id) {
		contactRepository.delete(contactRepository.findById(id));	
	}
}
