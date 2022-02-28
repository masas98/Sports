package lt.bit.Sport.services;

import java.util.Collection;
import java.util.HashSet;

import org.apache.catalina.webresources.TomcatJarInputStream;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lt.bit.Sport.entities.Client;

public class SecClientDetails implements UserDetails{
	
	private Client client;
	
	public SecClientDetails() {
		
	}	
	
	public SecClientDetails(Client client) {
		this.client=client;
	}
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		HashSet<GrantedAuthority> auth= new HashSet<>();
		auth.add(new SimpleGrantedAuthority(this.client.getRole()));
		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.client.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.client.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Client getClient() {
		return this.client;
	}

}
