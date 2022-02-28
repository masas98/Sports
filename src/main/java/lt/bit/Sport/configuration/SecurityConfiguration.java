package lt.bit.Sport.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lt.bit.Sport.services.ClientService;
import lt.bit.Sport.services.SecClientService;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	SecClientService clientService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth
			.userDetailsService(clientService)
			.passwordEncoder(passwordEncoder());
			
//			.inMemoryAuthentication()
//			.withUser("user").password(new BCryptPasswordEncoder().encode("user")).roles("user")
//			.and()
//			.withUser("admin").password(new BCryptPasswordEncoder().encode("admin")).roles("admin","user");
	}
	
	
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		
		.antMatchers("/addClient").hasAuthority("admin")
		.antMatchers("/updateClient").hasAuthority("admin")
		.antMatchers("/deleteClient").hasAuthority("admin")
		.antMatchers("/deleteWorkout").hasAuthority("ROLE_admin")
		.antMatchers("/addWorkout").hasAuthority("admin")
		.antMatchers("/updateWorkout").hasAuthority("admin")
		
		.antMatchers("/register").permitAll()
		.antMatchers("/files").permitAll()
		.antMatchers("/css/style.css").permitAll()
		.antMatchers("/login*").permitAll()
		.antMatchers("/workoutsCount").permitAll()
		.anyRequest().authenticated()
		
	.and()
		.formLogin()
		.loginPage("/login")
		.failureUrl("/login-error")
	.and()
		.logout()
		.logoutSuccessUrl("/login")
		.logoutUrl("/atsijungti");
	
	}





	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
