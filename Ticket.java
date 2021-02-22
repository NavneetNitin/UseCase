package usecase;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time. LocalDate;
import java.util.Collection;
import java.util.HashMap;

public class Ticket {


	
	private int counter;
	private String pnr;
	private LocalDate date;
	private Train train;
	private HashMap<Passenger, Double> passengers;

	public Ticket(LocalDate date, Train train) {
		super();
		this.date = date;
		this.train = train;
	}
	String generatePnr() 
	{
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(train.getSource().charAt(0));
		stringBuilder.append(train.getDestination().charAt(0));
		stringBuilder.append("_");
		stringBuilder.append(date);
		stringBuilder.append("_");
		stringBuilder.append(counter);
		pnr=stringBuilder.toString();
		return pnr;
				
	}

	public void setPassengers(HashMap<Passenger, Double> passengers)
	{
		this.passengers = passengers;
	}

	void addPassenger(Passenger passenger)
	{
		passengers = new HashMap<Passenger, Double>();
		passengers.put(new Passenger(passenger.getName(), passenger.getAge(), passenger.getGender()),calcPassengerFare(passenger));

	}


	double calcPassengerFare (Passenger passenger)

	{

		if (passenger.getAge() <=12)
			return train.getTicketPrice ()*0.5;
		else if (passenger.getAge() >=54)
			return train.getTicketPrice () *0.6;
		else if (passenger.getGender ()=='F')
			return train.getTicketPrice () *0.25;

		return train.getTicketPrice ();
	}
	public double totalTicketPrice()
	{
		double totalTicketPrice=0;
		totalTicketPrice=totalTicketPrice+train.getTicketPrice();
		return totalTicketPrice;
	}
	
	public void writeTicket() throws FileNotFoundException
	{
		PrintWriter pw = new PrintWriter ("pnr");

		{
			pw.write (generateTicket());
			pw.flush();
			pw.close();
		}
	}
	
	public String generateTicket() {
		return "Ticket [  pnr=" + pnr + "\n, Travel date=" + date + "\n, train=" + train + "\n, passengers="
				+ passengers + "]";
	}
	
	
	
	
	
	
	

	
	
	

}
