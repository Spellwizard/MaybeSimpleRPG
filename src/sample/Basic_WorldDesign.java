package sample;

//used for the actual window
import javax.swing.*;

//
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Basic_WorldDesign extends JPanel

{

    //Make a screen with a movable player with w,a,s,d
    //the player cannot exceed the boundary of the screen size
    //For now the screen can't change size and should be 500x500
    //Whenever the player moves allow for an update of other game actions eg: enemey movements



    //set the screen size to be called when making the window and controlling the boundary's of the player movement
    int X_WINDOW = 500;
    int Y_WINDOW = 500;

    //set the player positions
    int X_PlayerPOS = 250;
    int Y_PlayerPOS = 250;

    //Player size eg: actual 'hitbox' or the area to check when asking about collisions
    //This is a square shape
    int player_size = 15;

    //controll the distance the player will move on each movement call
    int player_moovement = 10;


    //actually make the entity to make a new screen with the entitled name
    JFrame mainScreen = new JFrame("Basic_WorldDesign");

    //make the keylistener which is used to track any actions taken on the window
    KeyListener InputTracker = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {


            // for quick testing and use of find each key code on the fly
            //System.out.println(e.getKeyCode()+" ");

            //Player movements for W,A,S,D
            // and make sure that such a move won't move the player off the map

            //Check if key 'W' is pressed to move character up

            if (e.getKeyCode()==87 && ((Y_PlayerPOS+=player_moovement)<Y_WINDOW)){
                Y_PlayerPOS += player_moovement;
                //Check if 'A' is pressed to move character left
            } else if (e.getKeyCode()==65) {
                X_PlayerPOS -= player_moovement;
                //Check if 'S' is pressed to move character down
            } else if (e.getKeyCode()==83&&(Y_PlayerPOS-=player_moovement)>0) {
                Y_PlayerPOS -= player_moovement;
                //check is 'D' is pressed to move character right
            } else if (e.getKeyCode()==68) {
                X_PlayerPOS += player_moovement;
            }

            //For debug purposes provide player location on pressing spacebar
            else if (e.getKeyCode()==32){
                System.out.println("The current player position: "+ X_PlayerPOS+", " +Y_PlayerPOS);
            }

            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };

    public Basic_WorldDesign(){
        //make the screen
        //set the window size
        mainScreen.setSize(X_WINDOW,Y_WINDOW);
        //Make sure we can actually see the screen
        mainScreen.setVisible(true);
        //Ensure the program closes when we ask
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //link the screen to the key listener so that any key presses when focused on the screen is actionable
        mainScreen.addKeyListener(InputTracker);

        //Stop the screen from being resizable
        mainScreen.setResizable(false);


        mainScreen.getContentPane().add(this);

        this.repaint();
    }




    public void paint(Graphics g){
        mainScreen.removeAll();
        g.setColor(Color.RED);
        g.fillRect(X_PlayerPOS,Y_PlayerPOS,player_size,player_size);
        System.out.println("I repainted my masterpeice");

    }

}
