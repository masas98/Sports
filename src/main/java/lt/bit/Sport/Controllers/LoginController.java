package lt.bit.Sport.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.bit.Sport.entities.Client;
import lt.bit.Sport.services.ClientService;

@Controller
public class LoginController {
	
	@Autowired
	ClientService clientService;
	
//	@Autowired
//	AuthenticationManager authenticationManager;
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("login-error")
	public String loginError(Model model) {
		model.addAttribute("isError", true);
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if (auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("client", new Client());
		return "register";
	}
	
	@PostMapping("/register")
	public String onRegister(@Valid @ModelAttribute Client client,BindingResult result ,Model model) {
		if (result.hasErrors()) {
			return "register";
		}
		

		clientService.addClient(client); /*Čia baigiau paskaitos laikas bv 02:13:11*/
//		UsernamePasswordAuthenticationToken login=new UsernamePasswordAuthenticationToken(client.getUsername(), password);
//		Authentication authentication=authenticationManager.authenticate(login);
//		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		
//		return "redirect:/login";
		model.addAttribute("isRegistred", true);
		return this.login();
	}
}
