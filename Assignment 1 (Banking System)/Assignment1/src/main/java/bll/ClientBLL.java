package bll;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import bll.validators.AgeValidator;
import bll.validators.SsnValidator;
import bll.validators.Validator;
import dao.ClientGateway;
import model.Client;


public class ClientBLL {
	private List<Validator<Client>> validators;

	public ClientBLL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new AgeValidator());
		validators.add(new SsnValidator());
	}

	public int add(Client c) {
		for (Validator<Client> v : validators) {
			v.validate(c);
		}
		return ClientGateway.add(c);
	} 
	
	public Client viewInfo(String ssn) {
		
		Client c = ClientGateway.viewInfo(ssn);
		if (c == null) {
			throw new NoSuchElementException("The client having the ssn = " + ssn + " was not found!");
		}
		return c;
	}
	
	public Client viewInfoByName(String name) {
		
		Client c = ClientGateway.viewInfoByName(name);
		if (c == null) {
			throw new NoSuchElementException("The client having the name = " + name + " was not found!");
		}
		return c;
	}
	
	public int update(Client c) {
		for (Validator<Client> v : validators) {
			v.validate(c);
		}
		return ClientGateway.update(c);
	}
	
	public int lastId() {
		return ClientGateway.lastId();
	}
	
}
