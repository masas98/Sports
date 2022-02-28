package lt.bit.Sport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.bit.Sport.classes.WorkoutsCount;
import lt.bit.Sport.entities.Client;
import lt.bit.Sport.entities.Workout;
import lt.bit.Sport.repositories.ClientRepository;
import lt.bit.Sport.repositories.WorkoutRepository;

@Service
public class WorkoutsServices {
	
	
	@Autowired
	WorkoutRepository workoutRepository;
	
	public List<Workout> getWorkouts(){
		return workoutRepository.findAll();
	}
	
	public Workout addWorkout(Workout workout) {
		return workoutRepository.save(workout);
	}
	
	public Workout getWorkoutsById(Integer id) {
		return workoutRepository.findById(id).orElse(null);
	}
	
	public Workout updateWorkouts(Workout workout) {
		Workout old=this.getWorkoutsById(workout.getId());
		old.setName(workout.getName());
		old.setDate(workout.getDate());
		old.setLocation(workout.getLocation());
		old.setModel(workout.getModel());
		old.setPlaces(workout.getPlaces());
		workoutRepository.save(old);
		return old;
	}
	
	public void deleteWorkout(Integer id) {
		workoutRepository.deleteById(id);
	}
	
	public List<WorkoutsCount> countWorkouts(){
		return workoutRepository.countWorkouts();
	}

}
