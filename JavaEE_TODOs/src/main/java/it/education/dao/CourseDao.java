package it.education.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import it.education.entity.Course;
import it.education.utils.JdbcUtil;

public class CourseDao {

	public static void create(Course courseRef) {
		String sqlQuery = 
		"insert into Course_Master values(?,?,?,?,?)";
		try(
				Connection dbConnection = JdbcUtil.buildConnection();
				PreparedStatement pstmt = dbConnection.prepareStatement(sqlQuery)
				){
				//Retrieving data from customerRef
			int newid =courseRef.getCourseid();
			String name = courseRef.getName();
			String provider =courseRef.getProvider();
		      int duration =courseRef.getDuration();
		      int  fees = courseRef.getFees();
			
				
				
				//Setting the data in place of unknown parameters.
			pstmt.setInt(1, newid);

			pstmt.setString(2, name);

			pstmt.setString(3, provider);

			pstmt.setInt(4, duration);

			pstmt.setInt(5, fees);
				
				int updateCount = pstmt.executeUpdate();
				System.out.println(updateCount + " record inserted.");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	}
	

