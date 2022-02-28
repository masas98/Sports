package lt.bit.Sport.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="registrations")
public class Registrations {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Date registration_date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="workout_id")
	private Workout workout;
	
	@Column(insertable = false, updatable = false)
	private Integer workout_id;
	
	
	

	public Registrations() {
		
	}
	




	public Registrations(Date registration_date) {
		super();
		this.registration_date = registration_date;
	}






	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getRegistration_date() {
		return registration_date;
	}



	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	
	
	public String toString() {
		return this.client.getId()+"";	}





	public Client getClient() {
		return client;
	}





	public void setClient(Client client) {
		this.client = client;
	}





	public Workout getWorkout() {
		return workout;
	}





	public void setWorkout(Workout workout) {
		this.workout = workout;
	}









	
	
	
	
	
	
	
	
	

}
