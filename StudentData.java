package com.miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
	//Author- Abhay Badwane
public class StudentData {
	public static void main(String[]args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Your ID");
		int id = scanner.nextInt();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "6464");
			preparedStatement = connection.prepareStatement("select *from students where studentId=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			
			System.out.print("ID:"+resultSet.getInt(1));
			System.out.print(" Name:"+resultSet.getString(2));
			System.out.print(" "+resultSet.getString(3));
			System.out.print(" Score:"+resultSet.getString(4));
			System.out.print(" Grade:"+resultSet.getString(5));
			//ID:1 fName lName Score:10 Grade:A
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
		}
	}
}
