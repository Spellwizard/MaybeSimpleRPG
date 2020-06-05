package sample;


import javax.swing.*;

public class Main{

    public static void main(String[]args){
        System.out.println("Starting Main");
        //make the class and start the initial sheet construction needed
        Menu frame = new Menu("Game Menu");

        //make sure the window will stop program on closing window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //make the window visible
        frame.setVisible(true);
    }



}


