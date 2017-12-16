package com.udemy.backendninja.component;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertContactModelToContactEntity(ContactModel contactModel) {
		Contact contactEntity = new Contact();
		contactEntity.setId(contactModel.getId());
		contactEntity.setFirstName(contactModel.getFirstName());
		contactEntity.setLastName(contactModel.getLastName());
		contactEntity.setCity(contactModel.getCity());
		contactEntity.setTelephone(contactModel.getTelephone());
		return contactEntity;
	}

	public ContactModel convertContactToContactModel(Contact contactEntity) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contactEntity.getId());
		contactModel.setFirstName(contactEntity.getFirstName());
		contactModel.setLastName(contactEntity.getLastName());
		contactModel.setTelephone(contactEntity.getTelephone());
		contactModel.setCity(contactEntity.getCity());
		return contactModel;
	}

}
