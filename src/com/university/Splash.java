package com.university;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;





public class Splash {





    public static void main(String[] args) {

        Frame   f = new Frame("University Management System");//creating frame
        f.setVisible(true); //
        int i;
        int x = 1;
        for (i=2;i<=600;i+=4,x+=1){

            f.setLocation((800-(i+x/2)),500-(i/2));
            f.setSize(i+3*x,i+x/2);

            try{

                Thread.sleep(10);
            }catch(Exception e){ }
        }


    }


}
class Frame extends JFrame implements  Runnable {

    //first task

    Thread t1; //multi threading thread class object

    Frame(String s) { //constructer to build frame
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("com/university/icons/first.jpg"));
        Image i1 = c1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);//for set up image
        ImageIcon i2 = new ImageIcon(i1); // i cant directly put i1 so creating imageicon label allowes icon

        JLabel m1 = new JLabel(i2);
        add(m1);
        t1 = new Thread(this);
        t1.start(); // it implicitly call run
        //if we call run directly then it not act as multithreading and both from execute together
    }

    public void run(){

        try{
            Thread.sleep(7000);
            this.setVisible(false);//by default all frame in java is false
            new Login();
        }catch (Exception e){

            e.printStackTrace();
        }


    }







}
