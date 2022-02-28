package lt.bit.Sport.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lt.bit.Sport.entities.Registrations;

import lt.bit.Sport.services.ClientService;
import lt.bit.Sport.services.RegistrationService;
import lt.bit.Sport.services.WorkoutsServices;

@Controller
public class RegistrationController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	WorkoutsServices workoutsServices;
	
	@Autowired
	RegistrationService registrationService;
	

	@GetMapping("/registerWorkout")
	public String saveWorkout(Model model) {
		model.addAttribute("registration", clientService.getMyRegistrations());
		model.addAttribute("workouts", workoutsServices.getWorkouts());
		return "registerWorkout";
	}
	
	@PostMapping ("/registerWorkout")
	public String saveWorkout(
			@Valid
			@ModelAttribute(name = "workouts")
			Registrations registrations,
			BindingResult result,
			
			@RequestParam ("workoutId")
			Integer workoutId,
			
			
			Model model) {
		registrations.setWorkout(workoutsServices.getWorkoutsById(workoutId));
		if(result.hasErrors()) {
			return "redirect:/";
		}
		registrationService.addRegistration(registrations);
		return "redirect:/";
	}
	
	@GetMapping("/deleteRegistration")
	public String deleteRegistration(@RequestParam("id") Integer id ) {
			registrationService.deleteRegistration(id);
			return "redirect:/";
			}
	
	
	
	

	
	

}
