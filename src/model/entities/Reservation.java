package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import modelexception.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checKin;
	private Date checkOut;
	
	
	// FOI COLOCADO static para que não seja estanciado um novo SimpleDateFormat 
	//para cada objeto Reservation que minha aplicação tiver pois só preciso de apenas 1
		
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation () {

	}

	public Reservation(Integer roomNumber, Date checKin, Date checkOut){
		if (!checkOut.after(checKin)) {
			throw new DomainException(" Check-out date must be after check-in date");
		} 
		this.roomNumber = roomNumber;
		this.checKin = checKin;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getChecKin() {
		return checKin;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public void upDtaedates(Date checKin, Date checkOut){
		
		Date now = new Date();
		
		if (checKin.before(now) || checkOut.before(now)) {
			
			throw new DomainException(" Reservation dates for update must be future dates"); 
		} 
		else if (!checkOut.after(checKin)) {
			
			throw new DomainException(" Check-out date must be after check-in date");
		} 
		
		this.checKin = checKin;
		this.checkOut = checkOut;
		
	}
	
	//foi usado long pois e um inteiro muito maior que Integer
	// pois o valor que o maçete vai me retornar e  um valor long
	
	public long duration() {
		//começar a calcular a diferença entra as duas datas em mileasegundos
		//que é o mais natural da plataforma java
		
		//criar uma variável do tipo long
		//recebendo  a diferença das duas datas em milisegundos (checkOut.getTime() - checKin.getTime()) 
		//getTime() Devolve a quantidade de milisegundos dauela data
		
		long diff = checkOut.getTime() - checKin.getTime();
		//converter milisegundos para dias: TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return "Reservation: " + 
				"Room " + getRoomNumber() +
				", " + 
				"check-in: " +
				sdf.format(checKin) + 
				", " +
				"check-out: " + 
				sdf.format(checkOut) + 
				", " + 
				duration() + 
				" nights";
				
				//sdf.format serve para formatar as datas
	}
	
	
	
	
}
