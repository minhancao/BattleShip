import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class PlayerScreen extends JFrame
{
   private JLabel numOfShips;
   private JLabel numOfOwnShipsSunk;
   private JLabel numOfShipsSunk;
   private JLabel currentState ;
   private PlayerScreen enemyPlayer;
   private boolean gameOver;
   private boolean fiveShipsCreated;
    public PlayerScreen(String name, boolean show)
    {
        super(name);
        this.setLayout(new BorderLayout());
        
        this.add(new SelfGrid(name, this), BorderLayout.EAST);
        this.add(new AttackGrid(name, this), BorderLayout.WEST);
        this.add(new JLabel(name), BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        numOfShips = new JLabel("Number of own ships: " + PlayerData.playerOneNumOfShips);
        numOfOwnShipsSunk = new JLabel("Number of own ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
        numOfShipsSunk = new JLabel("Number of enemy ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
        String current;

        if(name == "Player1")
        {
           currentState = new JLabel("Player1 Setup");
        }
        
        else
        {
           currentState = new JLabel("Player2 Setup");
        }
        
        panel.add(numOfShips);
        panel.add(numOfOwnShipsSunk);
        panel.add(numOfShipsSunk);
        panel.add(currentState);
        this.add(panel, BorderLayout.SOUTH);
        
        JButton next = new JButton("next");
        next.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
               if(name == "Player1" && State.state == 0 && PlayerData.playerOneNumOfShips == 5)
               {
                  fiveShipsCreated = true;
               }
               
               if(name == "Player2" && State.state == 1 && PlayerData.playerTwoNumOfShips == 5)
               {
                  fiveShipsCreated = true;
               }
               
               if(fiveShipsCreated && name == "Player1")
               {
                  currentState.setText("Player1 Turn");
                  enemyPlayer.getNumOfShips().setText("Number of own ships: " + PlayerData.playerTwoNumOfShips);
                  enemyPlayer.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
                  enemyPlayer.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
               }
               
               if(fiveShipsCreated && name == "Player2")
               {
                  currentState.setText("Player2 Turn");
                  enemyPlayer.getNumOfShips().setText("Number of own ships: " + PlayerData.playerOneNumOfShips);
                  enemyPlayer.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
                  enemyPlayer.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
               }
               
               if(name == "Player1" && State.state == 2 && (PlayerData.playerOneNumOfShips != 0 || PlayerData.playerTwoNumOfShips != 0))
               {
                  State.state=3;
                  PlayerData.playerMoves = 0;  
                  currentState.setText("Player1 Turn");
               }
               
               if(name == "Player2" && State.state == 3 && (PlayerData.playerOneNumOfShips != 0 || PlayerData.playerTwoNumOfShips != 0))
               {
                  State.state=2;
                  PlayerData.playerMoves = 0;
                  currentState.setText("Player2 Turn");
               }   
               
               if(gameOver && State.state == 4 && name == "Player1" && PlayerData.playerTwoNumOfShips == 0)
               {
                  State.state = 6;
               }
               
               if(gameOver && State.state == 5 && name == "Player2" && PlayerData.playerOneNumOfShips == 0)
               {
                  State.state = 6;
               }
               
               if(!gameOver && State.state > 1 && name == "Player1" && PlayerData.playerTwoNumOfShips == 0)
               {
                  currentState.setText("Player1 Wins!");
                  State.state = 4;
                  gameOver = true;
               }
               
               if(!gameOver && State.state > 1 && name == "Player2" && PlayerData.playerOneNumOfShips == 0)
               {
                  currentState.setText("Player2 Wins!");
                  State.state = 5;
                  gameOver = true;
               }
               
               if(name == "Player1" && State.state == 0 && PlayerData.playerOneNumOfShips < 5)
               {
                  State.state = 0;
               }
               
               if(name == "Player2" && State.state == 1 && PlayerData.playerTwoNumOfShips < 5)
               {
                  State.state = 1;
               }
               
               
               
               if(fiveShipsCreated && State.state<2)
               {
                  State.state += 1;
               }
               
               
                State.next(State.state);  
            }
        });
        this.add(next, BorderLayout.CENTER);
        this.pack();
        this.setVisible(show);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void hideScreen() 
    {
        this.setVisible(false);
    }
    
    public void showScreen()
    {
      this.setVisible(true);
    }
    
    public JLabel getNumOfShips()
    {
       return numOfShips;
    }
    
    public JLabel getNumOfOwnShipsSunk()
    {
       return numOfOwnShipsSunk;
    }
    
    public JLabel getNumOfShipsSunk()
    {
       return numOfShipsSunk;
    }
    
    public JLabel getCurrentState()
    {
       return currentState;
    }
    
    public void receivePlayer(PlayerScreen play)
    {
       enemyPlayer = play;
    }
}