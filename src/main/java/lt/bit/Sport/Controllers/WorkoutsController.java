package lt.bit.Sport.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.bit.Sport.entities.Client;
import lt.bit.Sport.entities.Workout;
import lt.bit.Sport.repositories.WorkoutRepository;
import lt.bit.Sport.services.ClientService;
import lt.bit.Sport.services.WorkoutsServices;

@Controller
public class WorkoutsController {
	
	
	@Autowired
	WorkoutsServices workoutsServices;
	
		
	@GetMapping("/workouts")
	public String workouts(Model model) {
		model.addAttribute("workout", workoutsServices.getWorkouts());
		return "workouts"; 
	}
	
	@GetMapping("/addWorkout")
	public String addWorkout(Model model) {
		model.addAttribute("workout", new Workout());
		return "addWorkout";
	}

	
	@PostMapping ("/addWorkout")
	public String saveOwner(@ModelAttribute Workout workout, Model model) {
		workoutsServices.addWorkout(workout);
		return "redirect:/workouts";
	}
	
	@GetMapping("/updateWorkout")
	public String showWorkout(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("workout", workoutsServices.getWorkoutsById(id));
		return "updateWorkout";
	}
	
	@PostMapping ("/updateWorkout")
	public String updateWorkout(@ModelAttribute Workout workout, Model model) {
		workoutsServices.updateWorkouts(workout);
		return "redirect:/workouts";
	}
	
	@GetMapping("/deleteWorkout")
	public String deleteWorkout(@RequestParam("id") Integer id) {
		workoutsServices.deleteWorkout(id);
		return "redirect:/workouts";
		
	}
	@GetMapping("/workoutsCount")
	public String workoutCount(Model model) {
		model.addAttribute("workout", workoutsServices.countWorkouts());
		System.out.println(workoutsServices.countWorkouts());
		return "workoutsCount";
	}
}
