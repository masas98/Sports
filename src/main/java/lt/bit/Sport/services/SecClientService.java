package lt.bit.Sport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lt.bit.Sport.entities.Client;

@Service
public class SecClientService implements UserDetailsService{
	
	@Autowired
	ClientService clientService;
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Client client=clientService.findByUserName(username);
		if (client==null) {
			throw new UsernameNotFoundException("Vartotojas nerastas");
		}
		return new SecClientDetails(client);
	}
}
