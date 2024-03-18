package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class ProjectData {
	int score=0;
	int correct =0;
	String grade ="";
	String result ="";
	 String fname;
	String lname;
	
	public static void main(String[] args) throws SQLException {
		ProjectData project = new ProjectData();
		project.getLogic();
		project.getTable();
	}
	
	//Author- Abhay Badwane
	public void getLogic() throws SQLException  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number Of Students in Quiz");
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.println("Enter FirstName");
			String fname = scanner.next();
			System.out.println("Enter the LastName");
			String lname = scanner.next();
			Connection connection = null;
			PreparedStatement preparedStatement= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "6464");
			preparedStatement = connection.prepareStatement("select *from question1 order by rand() limit 10");

			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			
			System.out.println(resultSet.getString(2));//question

			System.out.println("A "+resultSet.getString(3));//A option1
			System.out.println("B "+resultSet.getString(4));//B option2
			System.out.println("C "+resultSet.getString(5));//C option3
			System.out.println("D "+resultSet.getString(6));//D option4
			 scanner = new Scanner(System.in);
			System.out.println("Enter Your Option");
			String a = scanner.next();
			String correctAns =resultSet.getString(7);
	
			if(correctAns.charAt(0)==a.charAt(0)) {
				System.out.println("Answer is correct");
				correct++;
				score++;
				}else {
					System.out.println("Correct Answer is " + resultSet.getString(7));
				}
	
		
			}
			System.out.println("Score: "+score+" out of 10");//Score: 9 out of 10
			
			if(correct<5) {
				result="Fail";
				
			}
			else {
				result="Pass";
			}
			if(correct>=8 && correct<=10){
		          System.out.println("Grade A : Very Good");
		          grade = "A";
		      }
		      else if(correct==6 || correct==7){
		          System.out.println("Grade B : Good");
		         grade = "B";
		      }
		      else if (correct==5) {
		          System.out.println("Grade C : Medium");
		         grade ="C";
		      }
		      else {
		    	  System.out.println("Grade D : Fail");
		    	  grade = "D";
		     }
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			connection.close();
			preparedStatement.close();
		}
		ProjectData project = new ProjectData();
		project.getUserData(fname,lname,score,grade);
	
		correct=0;
		score=0;
	}
	}
	
	
	public void getUserData(String fname, String lname, int score, String grade) throws SQLException {
	
	Connection connection1 = null;
	PreparedStatement preparedStatement1 = null;
	try {

		Class.forName("com.mysql.jdbc.Driver");
		connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "6464");
		preparedStatement1 = connection1.prepareStatement("insert into students(firstName,lastName,Score,Grade)values(?,?,?,?) ");
		preparedStatement1.setString(1, fname);
		preparedStatement1.setString(2, lname);
		preparedStatement1.setInt(3, score);
		preparedStatement1.setString(4, grade);
		//Storing the Student Data into students Table
		int b = preparedStatement1.executeUpdate();
	
		System.out.println("Student Data is Stored");

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		connection1.close();
		preparedStatement1.close();
	}
}
	
	
	public void getTable() throws SQLException {
	Connection connection2 = null;
	PreparedStatement preparedStatement2 = null;
	try {
	Class.forName("com.mysql.jdbc.Driver");
	connection2 =DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "6464");
	preparedStatement2 = connection2.prepareStatement("select *from students");
	ResultSet resultSet1 = preparedStatement2.executeQuery();
	System.out.println("Result Table:");// All Students Result

	while(resultSet1.next()) {
	
	System.out.print("ID:"+resultSet1.getInt(1));
	System.out.print(" Name:"+resultSet1.getString(2));
	System.out.print(" "+resultSet1.getString(3));
	System.out.print(" Score:"+resultSet1.getString(4));
	System.out.print(" Grade:"+resultSet1.getString(5));
	System.out.println();
	//ID:1 fName lName Score:10 Grade:A
	
	}
	}catch(Exception e) {
	e.printStackTrace();
	}finally {
	connection2.close();
	preparedStatement2.close();
}
}
}