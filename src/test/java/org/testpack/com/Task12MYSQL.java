package org.testpack.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class Task12MYSQL {

	public static void main(String[] args) throws SQLException {
		String URL="jdbc:mysql://localhost:3306";
		String UserName="root";
		String Password="Mohan@123";
		
		Connection con = DriverManager.getConnection(URL, UserName, Password);
		Statement s = con.createStatement();
		
		//String createdatabase="create database SQLGuvi";
		String use= "use SQLGuvi";
		String createtab="Create table Empl(empcode int,empname varchar(20),empage int,esalary int)";
		String Insertval="insert into Empl values(101,'Jenny',24,10000)";
		String Select="Select * from Empl";
		//s.execute(createdatabase);
		s.execute(use);
		//s.execute(createtab);
		//s.executeUpdate(Insertval);
		s.executeUpdate("insert into Empl values(102,'Jacky',30,20000)");
		s.executeUpdate("insert into Empl values(103,'Joe',20,40000)");
		s.executeUpdate("insert into Empl values(104,'John',30,80000)");
		s.executeUpdate("insert into Empl values(105,'Shameer',30,90000)");
		ResultSet rs = s.executeQuery(Select);
		while(rs.next()) {
		System.out.println(rs.getInt("empcode")+" "+rs.getString("empname")+" "+rs.getInt("empage")+" "+rs.getInt("esalary"));
		}
		con.close();
		
		
	}

}
