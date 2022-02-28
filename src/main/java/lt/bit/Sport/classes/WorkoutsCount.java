package lt.bit.Sport.classes;

import java.util.Date;

public class WorkoutsCount {
	private String name;
	private Date date;
	private Long number;
	
	
	
	

	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}




	public Long getNumber() {
		return number;
	}




	public void setNumber(Long number) {
		this.number = number;
	}




	public WorkoutsCount() {
	}




	public WorkoutsCount(String name, Date date, Long number) {
		super();
		this.name = name;
		this.date = date;
		this.number = number;
	}




	@Override
	public String toString() {
		return name + ", data: " + date + " užsiregistravusių skaičius "+ number;	}
	
	
	
	
	
	
}
