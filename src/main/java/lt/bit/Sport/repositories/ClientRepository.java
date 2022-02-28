package lt.bit.Sport.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.bit.Sport.classes.WorkoutsCount;
import lt.bit.Sport.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	Client findByUsername(String username);
	
//	@Query("SELECT new lt.bit.Sport.classes.WorkoutsCount(c.id, c.username, count(*)) FROM Client c LEFT JOIN c.registrations GROUP BY c.id")
//	List<WorkoutsCount> countWorkouts();
	

	
	
	
	
	

}
