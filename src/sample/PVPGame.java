package sample;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

        import java.awt.Color;
        import java.awt.Graphics;
        import java.awt.event.KeyListener;

//This is used to track keyboard inputs
import java.awt.event.KeyListener;

public class PVPGame extends JFrame implements ActionListener {


    private int WindowWidth = 700;
    private int WindowLength = 800;

    private int PlayerCount = 4;

    public ArrayList<Player> playerList = new ArrayList<Player>();

    public DebugWindow debugWindow = new DebugWindow();

    KeyListener InputTracker;


        public void keyPressed(KeyEvent e) {
            // for quick testing and use of find each key code on the fly
            //System.out.println(e.getKeyCode()+" ");

            //Player movements for W,A,S,D
            // and make sure that such a move won't move the player off the map

            //Check if key 'W' is pressed to move character up

            //for every player check the event key against that players keyboard buttons and make the player move in that direction unless the player would go off screen

            boolean needUpdate = false; // used to track if an update is actually needed to stop unneccessary drawing
            for(Player i: playerList){

                //check the player 'up' key against the pressed code
                if(i.getUp_key()==e.getKeyCode()){
                    i.setPos_y(i.getPos_y() -  i.getSpeed());
                    needUpdate = true;
                }
                else //check the player 'down' key against the pressed code
                    if(i.getDown_key()==e.getKeyCode()){
                        i.setPos_y(i.getPos_y() +  i.getSpeed());
                        needUpdate = true;
                    }
                    else //check the player 'left' key against the pressed code
                        if(i.getLeft_key()==e.getKeyCode()){
                            i.setPos_x(i.getPos_x() -  i.getSpeed());
                            needUpdate = true;
                        }
                        else //check the player 'right' key against the pressed code
                            if(i.getRight_key()==e.getKeyCode()){
                                i.setPos_x(i.getPos_x() +  i.getSpeed());
                                needUpdate = true;
                            }


                            //set the player to the max position allowed if exceeding window size


                             //This is sensitive to the size of the window and if the window size changes this offsets won't work
                             //stop the player from going beyond the bottom of the screen
                            if(i.getPos_y() + 16 + i.getHeight() > WindowLength){
                                i.setPos_y(WindowLength - (17+i.getSpeed())); // set the player in a 'bounce' away from the edge
                                needUpdate = true;
                            }

                             //stop the player from moving off the top of the window
                            else if (i.getPos_y() < 56){
                                i.setPos_y(57); //'bounce the player away from the top of the edge'
                                needUpdate = true;
                            }

                             //stop the player moving off the right side of the window
                            if(i.getPos_x() +  22 > WindowWidth){ //offset for the weird discrepency in window
                                // size vs visible size and offset the players size to prevent moving to far off the screen
                                i.setPos_x(WindowWidth-23); // boucnce the player away from the edge
                                needUpdate = true;
                            }


                             //stop the player moving off the left side of the window
                            if(i.getPos_x() - 5 < 0){
                                i.setPos_x(0 + i.getSpeed()+1);
                                needUpdate = true;
                            }

            }
            if(needUpdate){repaint();}// to stop lag, only update to the game when it is actually needed
            try{
            debugWindow.updateText("KeyPressed: "+e.getKeyCode());
            }catch(Exception a){System.out.println(a.toString());}
        }




        //these two are needed but will be unused

        public void keyTyped(KeyEvent e){
            for(Player i: playerList) {
                //check the player 'up' key against the pressed code
                if (i.getUp_key() == e.getKeyCode()) {
                    i.setPos_y(i.getPos_y() - i.getSpeed());
                    repaint();
                    //stop the player from moving off the top of the window
                    if (i.getPos_y() < 56){
                        i.setPos_y(57); //'bounce the player away from the top of the edge'
                        repaint();
                    }
                }


            }




        }

        public void keyReleased(KeyEvent e) {}




    public PVPGame(String windowName){

        System.out.println("New Sheet made: "+windowName);

        this.setTitle(windowName);


        this.init();

        repaint();

    }

    //set up all the initalized menu bar stuff
    private void menuBarInit(){

            setTitle("Simple menu");
            setSize(350, 250);
            setLocationRelativeTo(null);

        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("Options");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var eMenuItem = new JMenuItem("Open Debug Screen");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener((event) -> makeDebug());

        fileMenu.add(eMenuItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

private void makeDebug(){
      debugWindow.init();
      debugWindow.updateText("\n------------------\n\nStarting Debug\n\n------------------------");
}

    //used on making a new sheet class object
    private void init(){
        try{
        debugWindow.updateText("starting initialization of PVPGame.java");
    }catch(Exception e){System.out.println(e.toString());}

        menuBarInit();



        //this.setVisible(true);
        try{
            debugWindow.updateText("This program is: "+this.isVisible());
        }
        catch(Exception e){System.out.println(e.toString());}

        int progress = 0;
        try {
            debugWindow.updateText("I made it this far" + progress++);
        }catch(Exception e){System.out.println(e.toString());}
        //set the window size
        this.setSize(WindowWidth,WindowLength);
        try{
        debugWindow.updateText("I made it this far"+ progress++);
        }catch(Exception e){System.out.println(e.toString());}
        //Add a focus on the window to track for keyboard inputs
        this.addKeyListener(InputTracker);

try{
        debugWindow.updateText("Playersize should be 0 : "+playerList.size() +"\n");
}catch(Exception e){System.out.println(e.toString());}

        //for each player involved in the game, make a new player class to track the player related things and
        // add that player to the player list

        try {

        for(int i = PlayerCount-1; i>-1;i--){

            playerList.add(new Player());
            try{
            debugWindow.updateText("I made it this far"+ progress++ +", Interger 'I' is:" + i);
        }catch(Exception e){System.out.println(e.toString());}
        }


        int counter = 0;

        for(Player i: playerList){

            i.setHeight(20);
            i.setWidth(12);

            if(counter!=PlayerCount){
                if(counter == 0){
                    i.setPos_x(300);
                    i.setPos_y(300);
                    i.setPColor(Color.BLUE);

                }
                else if(counter == 1){
                    i.setPos_x(400);
                    i.setPos_y(300);
                    i.setPColor(Color.GREEN);
                    i.setUp(84); // set the up to 't'
                    i.setDown(71); // set the down to ''
                    i.setLeft(70);//set the left to 'f'
                    i.setRight(72); // set the right to 'h'
                }
                else if(counter == 2){
                    i.setPos_x(300);
                    i.setPos_y(400);
                    i.setPColor(Color.RED);
                    i.setUp(73); // set the up to 'i'
                    i.setDown(75); // set the down to 'k'
                    i.setLeft(74);//set the left to 'j'
                    i.setRight(76); // set the right to 'l'
                }
                else if(counter == 3){
                    i.setUp(38); // set the up to 'up arrow'
                    i.setDown(40); // set the down to 'down arrow'
                    i.setLeft(37);//set the left to 'left arrow'
                    i.setRight(39); // set the right to 'right arrow'
                    i.setPos_x(400);
                    i.setPos_y(400);
                    i.setPColor(Color.WHITE);
                }
                counter++;
            }


        }

        }
        catch(Exception e){
            System.out.println("Error in PVPGame.java 'init' function\n"+e.toString());
        }
        //possibly a map class that would allow for opting in differnet terrian, enemies, hazards, background, and player positions
        //this may solve the problem of player positions in the game

try{
        debugWindow.updateText("I made it this far"+ progress++ + ", to the repainting");
}catch(Exception e){System.out.println(e.toString());}
        //repaint();

    } // end of init function




    public void paint(Graphics g) {
        // clear the screen of all elements
        super.paint(g);
try{
        debugWindow.updateText("Got to the paint function");
}catch(Exception e){System.out.println(e.toString());}
        //translate the internal logic of item locations to the window visual

        //draw the background stuff



        //for every player draw them on the board
        try{
        debugWindow.updateText("player list size: "+playerList.size());
        }catch(Exception e){System.out.println(e.toString());}
        try {
            String playerUpdates ="";
            for (Player i : playerList) {
                //draw a rectangle accoriding to the player color, size, and position
                //set the graphics color to draw with
                g.setColor(i.getPColor());
                //draw the rectangle where the player is
                int X = i.getPos_x();
                int Y = i.getPos_y();
                int width = i.getWidth();
                int height = i.getHeight();
                g.fillRect(X, Y, width, height);
                playerUpdates+="I drew a player: "+i.getPos_x()+", "+i.getPos_y()+"\n\n";

            }
            try{
            debugWindow.updateText(playerUpdates);
            }catch(Exception e){System.out.println(e.toString());}
        } catch (Exception e) {
            debugWindow.updateText("Error -- Players not drawn\n\n" + e.toString());
        }


    }


    //this can be used to check if a button, check box or the like is used
    public void actionPerformed(ActionEvent ae){
        String action = ae.getActionCommand();


        if(action.equals("BQuit")){
            System.exit(0);
        }
        }



    }



