package com.university;


import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentAttendanceDetail extends JFrame implements ActionListener {

    JTable j1;
    JButton b1;
    String h[] = {"Roll Number", "Date Time", "First Half", "Second Half"};  //becuse static data is there
    String d[][] = new String[15][4]; //dynamic data are coming from databases
    int i = 0, j = 0;

    StudentAttendanceDetail() {
        super("View Students Attendence");
        setSize(800, 300);
        setLocation(450, 150);

        try {
            String q = "select * from attendance_student";
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery(q);
            while (rs.next()) {
                d[i][j++] = rs.getString("rollno");
                d[i][j++] = rs.getString("Date");
                d[i][j++] = rs.getString("first");
                d[i][j++] = rs.getString("second");
                i++;
                j = 0;
            }

            j1 = new JTable(d, h);

        } catch (Exception e) {
        }

        b1 = new JButton("Print");
        add(b1, "South");//border layout bydefault
        JScrollPane s1 = new JScrollPane(j1);
        add(s1);

        b1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            j1.print(); //for print
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new StudentAttendanceDetail().setVisible(true);
    }
}

