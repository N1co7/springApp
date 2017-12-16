
package com.udemy.backendninja.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.impl.ContactServiceImpl;


@Controller()
@RequestMapping("/contacts")
public class contactController {
	
	/** The contact service impl. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactServiceImpl contactServiceImpl;
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(contactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
		
	}
	

	@GetMapping("/showcontacts")
	public String contactList(@RequestParam(name="result", required=false) Integer result, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", user.getUsername());
		model.addAttribute("contacts", contactServiceImpl.listContactModel());
		model.addAttribute("result", result);
		return ViewConstant.CONTACTS;
	}
	

	//@PreAuthorize("hasRole(permitAll()")
	@GetMapping("/contactform")
	public String contactForm(@RequestParam(name = "id", required=false) int id, Model model) {
		LOG.info("   contactForm() ");
		ContactModel contactModel = new ContactModel();
		if(id != 0) {
			contactModel = contactServiceImpl.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contactModel);
		return ViewConstant.CONTACT_FORM;
	}
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel, Model model){
		Integer result;
		LOG.info(" addContact()"+ contactModel.toString());
		if(contactServiceImpl.addContact(contactModel) != null) {
			result = 1;
		}else {
			result = 0;
		}
		return "redirect:/contacts/showcontacts?result="+ result;
	}
	

	@PostMapping("deletecontact2")
	public String deleteContact2(@ModelAttribute(name="id") int id) {
		contactServiceImpl.deleteContact(id);
		return "redirect:/contacts/showcontacts";
	}
}
