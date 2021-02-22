package usecase;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.*;

public class TrainDao {

	static final String Driver_Name="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/train?autoReconnect=true&useSSL=false";

	static final String USERNAME= "root";
	static final String PASSWORD = "root";


	Train findTrain (int trainNo)
	{

		Train train=null;

		try {

			//step -1 load the driver class

			Class.forName (Driver_Name); 
			System.out.println("class found");

			//step-2 get the connection

			Connection con=  DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
			System.out.println ("connected");

			PreparedStatement ps= ((java.sql.Connection) con).prepareStatement("select * from trains where train_no = ?");
			ps.setInt(1, trainNo);
			ResultSet rs = ps.executeQuery();

//			while (rs.next ()) {
//
//				System.out.println (rs.getInt(1) +" "+ rs.getString(2) +" "+ rs.getString(3) +" "+rs.getInt(4));
//
//		}
		}
		catch (Exception e) {
			System.out.println(e);

		}
		return train;

	
}
}




