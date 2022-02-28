package lt.bit.Sport.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lt.bit.Sport.entities.Client;import lt.bit.Sport.entities.Workout;
import lt.bit.Sport.services.ClientService;

@Controller
public class ClientsController {
	
	@Autowired
	ClientService clientService;
	
	
	
	@Autowired
	PasswordEncoder passwordEncoder;
		
	@GetMapping("/")
	public String client(Model model, Authentication auth) {
		
		boolean admin=false;
		for(GrantedAuthority ga:auth.getAuthorities()) {
			if (ga.getAuthority().equals("admin")) {
				admin=true;
				break;
			}
		}
		if(admin) {
			model.addAttribute("client", clientService.getClients());
			return "clients";
		}else {
			model.addAttribute("registrations", clientService.getMyRegistrations());
		}return "registrations";
		
//		model.addAttribute("client", clientService.getClients());
		
		 
	}
	
	@GetMapping("/addClient")
	public String addClient(Model model) {
		model.addAttribute("client", new Client());
		return "addClient";
	}

	
	@PostMapping ("/addClient")
	public String saveOwner(
			@Valid
			@ModelAttribute(name = "client")
			Client client,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "addClient";
		}
		clientService.addClient(client);
		return "redirect:/";
	}
	
	
	@GetMapping("/updateClient")
	public String showClient(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("client", clientService.getClientById(id));
		return "updateClient";
	}
	
	@PostMapping ("/updateClient")
	public String updateClient(
			@Valid 
			@ModelAttribute
			Client client,
			BindingResult result, 
			Model model
			) {
		if(result.hasErrors()) {
			return "updateClient";
		}
		clientService.updateClients(client);
		return "redirect:/";
	}
	
	@GetMapping("/deleteClient")
	public String deleteClient(@RequestParam("id") Integer id ) {
			clientService.deleteClient(id);
			return "redirect:/";

}

	

	
	


	
	
	
}


