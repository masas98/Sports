package lt.bit.Sport.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.bit.Sport.classes.WorkoutsCount;
import lt.bit.Sport.entities.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer>{
	
	@Query("SELECT new lt.bit.Sport.classes.WorkoutsCount(w.name, w.date, count(*)) FROM Workout w LEFT JOIN w.registrations GROUP BY w.id")
	List<WorkoutsCount> countWorkouts();

}
