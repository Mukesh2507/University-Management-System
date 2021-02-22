package com.university;
import java.sql.*;
 public class Conn {


     Connection c;//connection create
     Statement s;

     public Conn() {
         try {


            //class.forName("com.mysql.jdbc.Driver");//load the class
             DriverManager.registerDriver(new com.mysql.jdbc.Driver());//second way of loading driver
             c = DriverManager.getConnection("jdbc :mysql://locolhost:3306/ums", "root", " ");
             s = c.createStatement();//mysql will execute through this s
         } catch (Exception e) {

             System.out.println(e);
         }


     }

 }






