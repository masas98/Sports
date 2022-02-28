package lt.bit.Sport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import lt.bit.Sport.entities.Registrations;

public interface RegistrationRepository extends JpaRepository<Registrations, Integer>{
	List<Registrations> findByClientId(Integer client_id);
	
}
