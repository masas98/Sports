package lt.bit.Sport.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="workout")
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String model;
	
	
	@Column
	private Date date;
	
	@Column
	private String places;
	
	@Column
	private String location;
	
	@OneToMany(mappedBy = "workout", fetch = FetchType.EAGER)
	private List<Registrations> registrations;
	
	
	
	
	

	public Workout() {
		
	}

	public Workout(String name, String model, Date date, String places, String location,
			List<Registrations> registrations) {
		super();
		this.name = name;
		this.model = model;
		this.date = date;
		this.places = places;
		this.location = location;
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

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPlaces() {
		return places;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Registrations> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<Registrations> registrations) {
		this.registrations = registrations;
	}
	
	
	

	

	
}
