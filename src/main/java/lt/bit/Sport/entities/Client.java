package lt.bit.Sport.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lt.bit.Sport.constrains.PhoneNumber;




@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	@NotEmpty
	@Size(min=3, max=20)
	private String name;
	
	
	@Column
	@NotEmpty
	@Size(min=3, max=25)
	private String surname;
	
	@Column
	@Size(max=40)
	@Email(message = "Įveskite teisingą el.pašto adresą!")
	private String email;
	
	
	
	@Column
	@Size(max=15)
	@PhoneNumber
	private String phone;
	
	@Column(nullable = false, unique = true)
	@NotEmpty
	private String username;
	
	@Column(nullable = false)
	@NotEmpty
	private String password;
	
	@Column(nullable = false)
	@NotEmpty
	private String role="user";
	
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	private List<Registrations> registrations;
	
	
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Client() {
		
	}

	public Client(@NotEmpty @Size(min = 3, max = 20) String name, @NotEmpty @Size(min = 3, max = 25) String surname,
			@Size(max = 40) @Email(message = "Įveskite teisingą el.pašto adresą!") String email,
			@Size(max = 15) String phone, @NotEmpty String username, @NotEmpty String password, @NotEmpty String role,
			List<Registrations> registrations) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.role = role;
		this.registrations = registrations;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Registrations> getRegistrations() {
		return registrations;
	}


	public void setRegistrations(List<Registrations> registrations) {
		this.registrations = registrations;
	}
	
	public String toString() {
		return this.name;
	}

	


}
