package lt.bit.Sport.services;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.engine.query.spi.sql.NativeSQLQueryCollectionReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lt.bit.Sport.classes.WorkoutsCount;
import lt.bit.Sport.entities.Registrations;
import lt.bit.Sport.repositories.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	RegistrationRepository registrationRepository;
	
	
	public Registrations addRegistration(Registrations registration) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) return null;
		SecClientDetails secClient=(SecClientDetails)auth.getPrincipal();
		registration.setClient(secClient.getClient());
		java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
		registration.setRegistration_date(date);
		return registrationRepository.save(registration);
	}
	
	public List<Registrations>getMyRegistrations(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth==null) return null;
		SecClientDetails secClient=(SecClientDetails)auth.getPrincipal();
		return registrationRepository.findByClientId(secClient.getClient().getId());
		
	}
	
	public void deleteRegistration(Integer id) {
		registrationRepository.deleteById(id);
	}
	

	
	
}
