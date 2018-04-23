import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
Represents the player's own grid
*/
public class SelfGrid extends BattleGrid// implements MouseListener
{
   private String player;
   private PlayerScreen play;
    public SelfGrid(String name, PlayerScreen playerScreen) 
    {
        super();
        player = name;
        play = playerScreen;     
    }

    @Override
    protected JPanel getCell()
    {
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 5));
        panel.setPreferredSize(new Dimension(20, 20)); // for demo purposes only
        /*
        panel.addMouseListener(new MouseAdapter()
        {
         Color currentBackground;
         @Override
         public void mouseEntered(MouseEvent e)
         {
            currentBackground = panel.getBackground();
            panel.setBackground(Color.YELLOW);
         }
         
         @Override
         public void mouseExited(MouseEvent e)
         {
            panel.setBackground(currentBackground);
         }
        });*/

        
        panel.addMouseListener(new MouseAdapter()
        {
         @Override
         public void mouseClicked(MouseEvent e)
         {  
            int num = 0;
            
          //vertical to horizontal orientation for p1
            if(State.state <= 1 && player == "Player1" && PlayerData.playerOneNumOfShips <= 5 && panel.getX()+40 < 200 && PlayerData.checkPlayerOneShipsAtk(panel.getX()/20, panel.getY()/20) && PlayerData.checkIsVerticalPlayerOneShips(panel.getX()/20, panel.getY()/20)
                  && findComponentAt(panel.getX()+20, panel.getY()).getBackground() != Color.GRAY && findComponentAt(panel.getX()+40, panel.getY()).getBackground() != Color.GRAY)
            {
               num = 1;
            }
            
          //vertical to horizontal orientation for p2
            if(State.state <= 1 && player == "Player2" && PlayerData.playerTwoNumOfShips <= 5 && panel.getX()+40 < 200 && PlayerData.checkPlayerTwoShipsAtk(panel.getX()/20, panel.getY()/20) && PlayerData.checkIsVerticalPlayerTwoShips(panel.getX()/20, panel.getY()/20)
                  && findComponentAt(panel.getX()+20, panel.getY()).getBackground() != Color.GRAY && findComponentAt(panel.getX()+40, panel.getY()).getBackground() != Color.GRAY)
            {
               num = 3;  
            }
            
          //horizontal to vertical orientation for p1
            if(State.state <= 1 && player == "Player1" && PlayerData.playerOneNumOfShips <= 5 && panel.getY()+40 < 200 && PlayerData.checkPlayerOneShipsAtk(panel.getX()/20, panel.getY()/20) && PlayerData.checkIsHorizontalPlayerOneShips(panel.getX()/20, panel.getY()/20) 
                  && findComponentAt(panel.getX(), panel.getY()+20).getBackground() != Color.GRAY && findComponentAt(panel.getX(), panel.getY()+40).getBackground() != Color.GRAY)
            {
               num = 2;
               
            }
            
            //horizontal to vertical orientation for p2
            if(State.state <= 1 && player == "Player2" && PlayerData.playerTwoNumOfShips <= 5 && panel.getY()+40 < 200 && PlayerData.checkPlayerTwoShipsAtk(panel.getX()/20, panel.getY()/20) && PlayerData.checkIsHorizontalPlayerTwoShips(panel.getX()/20, panel.getY()/20)
                  && findComponentAt(panel.getX(), panel.getY()+20).getBackground() != Color.GRAY && findComponentAt(panel.getX(), panel.getY()+40).getBackground() != Color.GRAY)
            {
               num = 4;
            }
            
            switch(num)
            {
               case 1:
                  panel.setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+20).setBackground(Color.BLACK);
                  findComponentAt(panel.getX(), panel.getY()+40).setBackground(Color.BLACK);
                  findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.GRAY);
                  findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.GRAY);
                  PlayerData.changeOrientationPlayerOneShips(panel.getX()/20, panel.getY()/20);
                  break;
                  
               case 2:
                  panel.setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+20).setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+40).setBackground(Color.GRAY);
                  findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.BLACK);
                  findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.BLACK);
                  PlayerData.changeOrientationPlayerOneShips(panel.getX()/20, panel.getY()/20);
                  break;
                  
               case 3:
                  panel.setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+20).setBackground(Color.BLACK);
                  findComponentAt(panel.getX(), panel.getY()+40).setBackground(Color.BLACK);
                  findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.GRAY);
                  findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.GRAY);
                  PlayerData.changeOrientationPlayerTwoShips(panel.getX()/20, panel.getY()/20);   
                  break;
                  
               case 4:
                  panel.setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+20).setBackground(Color.GRAY);
                  findComponentAt(panel.getX(), panel.getY()+40).setBackground(Color.GRAY);
                  findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.BLACK);
                  findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.BLACK);
                  PlayerData.changeOrientationPlayerTwoShips(panel.getX()/20, panel.getY()/20);  
                  break;        
            }
            
            if(State.state <= 1 && player == "Player1" && PlayerData.playerOneNumOfShips < 5 && panel.getX()+40 <= 200 && !PlayerData.checkForSpacePlay1(panel.getX()/20, panel.getY()/20))
            {
               panel.setBackground(Color.GRAY);
               findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.GRAY);
               findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.GRAY);
               PlayerData.updatePlayerOneShips(panel.getX()/20, panel.getY()/20);
               PlayerData.playerOneNumOfShips++;
               
               play.getNumOfShips().setText("Number of own ships: " + PlayerData.playerOneNumOfShips);
               play.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
               play.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);      
            }
            
            
            if(State.state <= 1 && player == "Player2" && PlayerData.playerTwoNumOfShips < 5 && panel.getX()+40 <= 200 && !PlayerData.checkForSpacePlay2(panel.getX()/20, panel.getY()/20))
            {
               panel.setBackground(Color.GRAY);
               findComponentAt(panel.getX()+20, panel.getY()).setBackground(Color.GRAY);
               findComponentAt(panel.getX()+40, panel.getY()).setBackground(Color.GRAY);
               PlayerData.updatePlayerTwoShips(panel.getX()/20, panel.getY()/20);
               PlayerData.playerTwoNumOfShips++;
                 
               play.getNumOfShips().setText("Number of own ships: " + PlayerData.playerTwoNumOfShips);
               play.getNumOfOwnShipsSunk().setText("Number of own ships sunk: " + PlayerData.playerTwoNumOfShipsSunk);
               play.getNumOfShipsSunk().setText("Number of enemy ships sunk: " + PlayerData.playerOneNumOfShipsSunk);
            }
  
         }
        });

        return panel;
    }
}