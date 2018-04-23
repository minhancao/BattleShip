import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
Represents the player's own grid
*/
public class AttackGrid extends BattleGrid
{
   private String player;
   private PlayerScreen play;
    public AttackGrid(String name, PlayerScreen playerScreen) 
    {
        super();
        player = name;
        play = playerScreen;
    }

    @Override
    protected JPanel getCell()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        panel.setBorder(BorderFactory.createLineBorder(Color.red, 5));
        panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only
        
        
        panel.addMouseListener(new MouseAdapter() //handles the attack
        {
         @Override
         public void mouseClicked(MouseEvent e)
         {
            if(PlayerData.playerMoves < 1 && State.state > 1)
            {
               if(player == "Player1")
               {
                  if(PlayerData.checkPlayerTwoShipsAtk(panel.getX()/20, panel.getY()/20))//hit
                  {
                     panel.setBackground(Color.GREEN); 
                     
                     PlayerData.playerTwoShips[panel.getX()/20][panel.getY()/20].setHit();
                     
                     if(PlayerData.allBoxesAtkedPlayerTwoShips(panel.getX()/20, panel.getY()/20))
                     {
                        PlayerData.playerTwoNumOfShips--;
                        PlayerData.playerTwoNumOfShipsSunk++;
                     }   
                  }
                  
                  else//miss
                  {
                     panel.setBackground(Color.YELLOW);
                  }
                  
                  play.getNumOfShips().setText("Number of own ships: " + PlayerData.playerOneNumOfShips);
                  play.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
                  play.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
               } 
               
               if(player == "Player2")
               {
                  if(PlayerData.checkPlayerOneShipsAtk(panel.getX()/20, panel.getY()/20))//hit
                  {
                     panel.setBackground(Color.GREEN);
                     
                     PlayerData.playerOneShips[panel.getX()/20][panel.getY()/20].setHit();
                     
                     if(PlayerData.allBoxesAtkedPlayerOneShips(panel.getX()/20, panel.getY()/20))
                     {
                        PlayerData.playerOneNumOfShips--;
                        PlayerData.playerOneNumOfShipsSunk++;
                     }  
                  }
                  
                  else//miss
                  {
                     panel.setBackground(Color.YELLOW);
                  }
                  
                  play.getNumOfShips().setText("Number of own ships: " + PlayerData.playerTwoNumOfShips);
                  play.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
                  play.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
               }
               PlayerData.playerMoves++;
            }
         }
        });

        return panel;
    }
}