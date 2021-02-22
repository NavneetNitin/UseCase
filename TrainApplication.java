package usecase;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TrainApplication {



	public static void main(String[] args)  {
		
		System.out.println("====Ticket Application====");

		DateTimeFormatter pattern =DateTimeFormatter.ofPattern("dd/MM/yyyy");
		TrainDao trainDao = new TrainDao();
		
		Scanner scanner = new Scanner (System.in);

		System.out.println ("enter the train number");
		int trainNumber = scanner.nextInt();

		System.out.println ("enter travel date"); 
		String travelDate = scanner.next();

		// calling the find train method passing train number as parameter which return train object 
		Train train =trainDao.findTrain (trainNumber);
		
		//if it is null no train found
		if (train==null) 
		{
			System.out.println ("train not found");
		}
		else {
			
			LocalDate myTravelDate = LocalDate.parse(travelDate, pattern);
			System.out.println("your travle date is "+ myTravelDate);
			System.out.println ("your travle date is with given pattern "+ myTravelDate.format(pattern));



			Ticket ticket= new Ticket(myTravelDate,train);

			//Adding passenger
			System.out.println("Enter total Passenger");
			int totalPassenger=scanner.nextInt();
			for(int i=1;i<=totalPassenger;i++) 
			{
				System.out.println("Enter name: ");
				String name=scanner.next();
				System.out.println("Enter Age : ");
				int age=scanner.nextInt();
				System.out.println("Enter gender(M/F): ");
				char gender=scanner.next().charAt(0);


				ticket.addPassenger(new Passenger(name,age,gender));

				Passenger p=new Passenger(name,age,gender);
				ticket.calcPassengerFare(p);
				
			}

			String costumerTicket=ticket.generateTicket();
			System.out.println(costumerTicket);

			try {
				ticket.writeTicket();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}



		}
	}

}


