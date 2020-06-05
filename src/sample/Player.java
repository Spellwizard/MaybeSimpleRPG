package sample;

import java.awt.*;

//The player input for actions is setable and is tracked for keyboard inputs using the coresponding numbers

public class Player {
    //interger used to track this player's position on the map
    //track player X position
    private int pos_x=0;
    //track player Y position
    private int pos_y=0;

    //track player speed, defaults to 1
    private int speed=10;
    //track the player size, for now the player is assumed to be a rectangle
    private int height=10;
    private int width=10;

    //variable used to track players color using the Color class
    private Color PColor;

    //Use the following numbers to track the keys that are used to move the player
    private int up_key=87; // default to 'w'
    private int down_key=83; // default to 's'
    private int left_key=65; // default to 'a'
    private int right_key=68; // default to 'd'


    //make a completly designed player setting all variables on creating player class
    //The movement keys are defaulted to 1 - up, 2 - down, 3 - left, 4 - up
    public Player(int X, int Y, int movementSpeed, int heigth, int length, Color Colour){
        pos_x = X; // the player's X position
        pos_y = Y; // the player's Y position
        speed=movementSpeed; // players speed
        height = heigth; // players size on the X axis
        width = length; // players size on the Y axis
        PColor = Colour; // the players color

    }

    //make a completly designed player setting all variables on creating player class
    public Player(int X, int Y, int movementSpeed, int heigth, int length, Color Colour,
                  int upwards, int downwards, int leftwards, int rightwards){

        pos_x = X; // the player's X position
        pos_y = Y; // the player's Y position
        speed=movementSpeed; // players speed
        height = heigth; // players size on the X axis
        width = length; // players size on the Y axis
        PColor = Colour; // the players color

        up_key = upwards;
        down_key = downwards;
        left_key = leftwards;
        right_key = rightwards;
    }

    //default class for quick builds of players
    //player interger values default to 0 and the color is orange
    public Player(){
        //all int's default to 0
        PColor = Color.PINK; // the players color
    }

    // Basic Getters for variables
    public int getPos_y(){return pos_y;}
    public int getPos_x(){ return pos_x;}
    public int getSpeed(){ return speed;}
    public int getHeight(){ return height;}
    public int getWidth(){ return width;}

    //get the player's current color
    public Color getPColor(){
        return PColor;
    }

    //return the key that is this players key to move upwards
    public int getUp_key(){
        return up_key;
    }
    public int getDown_key(){
        return down_key;
    }
    public int getLeft_key(){
        return left_key;
    }
    public int getRight_key(){
        return right_key;
    }


    //direct setters for variables
    public void setPos_x(int POSX){
        pos_x = POSX;
    }
    public void setPos_y(int POSY){
        pos_y = POSY;
    }

    public void setSpeed(int Movement){
        speed = Movement;
    }
    public void setHeight(int tall){
        height = tall;
    }
    public void setWidth(int fat){
        width = fat;
    }
    public void setPColor(Color Colour){
        PColor = Colour;
    }


    //These Setters are changing the keys #'s for the player movement for each respective direction
    public void setUp(int upwards){
        up_key=upwards;
    }
    public void setDown(int downards){
        down_key = downards;
    }
    public void setLeft(int leftwards){
        left_key = leftwards;
    }
    public void setRight(int rightwards){
        right_key = rightwards;
    }




}// end of Player class
