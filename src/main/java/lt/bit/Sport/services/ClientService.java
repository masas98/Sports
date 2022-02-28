package lt.bit.Sport.services;

import java.util.List;import org.hibernate.cache.spi.support.NaturalIdNonStrictReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import lt.bit.Sport.classes.WorkoutsCount;
import lt.bit.Sport.entities.Client;
import lt.bit.Sport.entities.Registrations;
import lt.bit.Sport.repositories.ClientRepository;
import lt.bit.Sport.repositories.RegistrationRepository;


@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	public List<Client> getClients(){
		return clientRepository.findAll();
	}
	
	public Client addClient(Client client) {
		client.setPassword(new BCryptPasswordEncoder().encode(client.getPassword()));
		return clientRepository.save(client);
	}
	
	public Client getClientById(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}
	
	public Client updateClients(Client client) {
		Client old=this.getClientById(client.getId());
		old.setName(client.getName());
		old.setSurname(client.getSurname());
		old.setEmail(client.getEmail());
		old.setPhone(client.getPhone());
		clientRepository.save(old);
		return old;
	}
	
	public void deleteClient(Integer id) {
		clientRepository.deleteById(id);
	}
	
	public Client findByUserName(String username) {
		return clientRepository.findByUsername(username);
		
	}
	
	
	public List<Registrations>getMyRegistrations(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) return null;
		SecClientDetails secClient=(SecClientDetails)auth.getPrincipal();
		return registrationRepository.findByClientId(secClient.getClient().getId());
		
	}
	
//	public List<WorkoutsCount> countWorkouts(){
//		return clientRepository.countWorkouts();
//	}
	

	
	
	

	

}
