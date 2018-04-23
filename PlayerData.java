
public class PlayerData 
{
   static Ship[][] playerOneShips = new Ship[10][10];
   static Ship[][] playerTwoShips = new Ship[10][10];
   static int playerOneNumOfShips = 0;
   static int playerTwoNumOfShips = 0;
   static int playerOneNumOfShipsSunk;
   static int playerTwoNumOfShipsSunk;
   static int playerMoves;
   
   static int state = 0; //0 = p1 setup, 1 = p2 setup, 2 = p1 turn, 3 = p2 turn, 4 = game over 
   
   public static void updatePlayerOneShips(int x, int y)
   {
      if(playerOneNumOfShips < 5)
      {
         int[] xCords = new int[3];
         xCords[0] = x;
         xCords[1] = x+1;
         xCords[2] = x+2;
         int[] yCords = new int[3];
         yCords[0] = y;
         yCords[1] = y;
         yCords[2] = y;
         playerOneShips[x][y] = new Ship(xCords, yCords);
         playerOneShips[x+1][y] = new Ship(xCords, yCords);
         playerOneShips[x+2][y] = new Ship(xCords, yCords);
      }
   }
   
   public static void updateVertPlayerOneShips(int x, int y)
   {
      if(playerOneNumOfShips < 5)
      {
         int[] xCords = new int[3];
         xCords[0] = x;
         xCords[1] = x;
         xCords[2] = x;
         int[] yCords = new int[3];
         yCords[0] = y;
         yCords[1] = y+1;
         yCords[2] = y+2;
         
         playerOneShips[x+1][y] = null;
         playerOneShips[x+2][y] = null;
         
         playerOneShips[x][y] = new Ship(xCords, yCords);
         playerOneShips[x][y+1] = new Ship(xCords, yCords);
         playerOneShips[x][y+2] = new Ship(xCords, yCords);
      }
   }
   
   public static void updateVertPlayerTwoShips(int x, int y)
   {
      if(playerOneNumOfShips < 5)
      {
         int[] xCords = new int[3];
         xCords[0] = x;
         xCords[1] = x;
         xCords[2] = x;
         int[] yCords = new int[3];
         yCords[0] = y;
         yCords[1] = y+1;
         yCords[2] = y+2;
         
         playerTwoShips[x+1][y] = null;
         playerTwoShips[x+2][y] = null;
         
         playerTwoShips[x][y] = new Ship(xCords, yCords);
         playerTwoShips[x][y+1] = new Ship(xCords, yCords);
         playerTwoShips[x][y+2] = new Ship(xCords, yCords);
      }
   }
   
   public static void updatePlayerTwoShips(int x, int y)
   {
      if(playerTwoNumOfShips < 5)
      {
         int[] xCords = new int[3];
         xCords[0] = x;
         xCords[1] = x+1;
         xCords[2] = x+2;
         int[] yCords = new int[3];
         yCords[0] = y;
         yCords[1] = y;
         yCords[2] = y;
         playerTwoShips[x][y] = new Ship(xCords, yCords);
         playerTwoShips[x+1][y] = new Ship(xCords, yCords);
         playerTwoShips[x+2][y] = new Ship(xCords, yCords);
      }
   }
   
   public static boolean checkPlayerOneShipsAtk(int x, int y)
   {
      if(playerOneShips[x][y] == null)
      {
         return false;
      }
      return true;
   }
   
   public static boolean checkPlayerTwoShipsAtk(int x, int y)
   {
      if(playerTwoShips[x][y] == null)
      {
         return false;
      }
      return true;
   }
   
   public static void changeOrientationPlayerOneShips(int x, int y)
   {
      int[] xCords = playerOneShips[x][y].getXCords();
      int[] yCords = playerOneShips[x][y].getYCords();
      boolean ran = false;
      
      if(y+1 < 10 && y+1 == yCords[1])//if it's vertical, switch to horizontal
      {
         xCords[0] = x;
         xCords[1] = x+1;
         xCords[2] = x+2;
         
         yCords[0] = y;
         yCords[1] = y;
         yCords[2] = y;
         playerOneShips[x][y+1] = null;
         playerOneShips[x][y+2] = null;
         
         playerOneShips[x][y] = new Ship(xCords, yCords);
         playerOneShips[x+1][y] = new Ship(xCords, yCords);
         playerOneShips[x+2][y] = new Ship(xCords, yCords);
         ran = true;
      }
      
      if(!ran && x+1 < 10 && x+1 == xCords[1])//if it's horizontal, switch to vertical
      {
         xCords[0] = x;
         xCords[1] = x;
         xCords[2] = x;

         yCords[0] = y;
         yCords[1] = y+1;
         yCords[2] = y+2;
         
         playerOneShips[x+1][y] = null;
         playerOneShips[x+2][y] = null;
         
         playerOneShips[x][y] = new Ship(xCords, yCords);
         playerOneShips[x][y+1] = new Ship(xCords, yCords);
         playerOneShips[x][y+2] = new Ship(xCords, yCords);
      }
   }
   
   public static void changeOrientationPlayerTwoShips(int x, int y)
   {
      boolean ran = false;
      int[] xCords = playerTwoShips[x][y].getXCords();
      int[] yCords = playerTwoShips[x][y].getYCords();
      
      if(y+1 < 10 && y+1 == yCords[1])//if it's vertical, switch to horizontal
      {
         xCords[0] = x;
         xCords[1] = x+1;
         xCords[2] = x+2;
         
         yCords[0] = y;
         yCords[1] = y;
         yCords[2] = y;
         playerTwoShips[x][y+1] = null;
         playerTwoShips[x][y+2] = null;
         
         playerTwoShips[x][y] = new Ship(xCords, yCords);
         playerTwoShips[x+1][y] = new Ship(xCords, yCords);
         playerTwoShips[x+2][y] = new Ship(xCords, yCords);
         ran = true;
      }
      
      if(!ran && x+1 < 10 && x+1 == xCords[1])//if it's horizontal, switch to vertical
      {
         xCords[0] = x;
         xCords[1] = x;
         xCords[2] = x;

         yCords[0] = y;
         yCords[1] = y+1;
         yCords[2] = y+2;
         
         playerTwoShips[x+1][y] = null;
         playerTwoShips[x+2][y] = null;
         
         playerTwoShips[x][y] = new Ship(xCords, yCords);
         playerTwoShips[x][y+1] = new Ship(xCords, yCords);
         playerTwoShips[x][y+2] = new Ship(xCords, yCords);
      }
   }
   
   public static boolean checkIsVerticalPlayerOneShips(int x, int y)
   {
      int[] yCords = playerOneShips[x][y].getYCords();
      
      if(yCords[2] == y+2)
      {
         return true;
      }
      
      return false;
   }
   
   public static boolean checkIsHorizontalPlayerOneShips(int x, int y)
   {
      int[] xCords = playerOneShips[x][y].getXCords();
      
      if(xCords[2] == x+2)
      {
         return true;
      }
      
      return false;
   }
   
   public static boolean checkIsVerticalPlayerTwoShips(int x, int y)
   {
      int[] yCords = playerTwoShips[x][y].getYCords();
      
      if(yCords[2] == y+2)
      {
         return true;
      }
      
      return false;
   }
   
   public static boolean checkIsHorizontalPlayerTwoShips(int x, int y)
   {
      int[] xCords = playerTwoShips[x][y].getXCords();
      
      if(xCords[2] == x+2)
      {
         return true;
      }
      
      return false;
   }
   
   public static boolean checkForSpacePlay1(int x, int y)
   {
      if(x+2 < 10 && playerOneShips[x][y] == null && playerOneShips[x+1][y] == null && playerOneShips[x+2][y] == null)
      {
         return false;
      }
      return true;
   }
   
   public static boolean checkForSpacePlay2(int x, int y)
   {
      if(x+2 < 10 && playerTwoShips[x][y] == null && playerTwoShips[x+1][y] == null && playerTwoShips[x+2][y] == null)
      {
         return false;
      }
      return true;
   }
   
   public static int getPlayerOneNumOfShips()
   {
      return playerOneNumOfShips;
   }
   
   public static int getPlayerTwoNumOfShips()
   {
      return playerTwoNumOfShips;
   }
   
   public static boolean allBoxesAtkedPlayerOneShips(int x, int y)
   {
      int[] xCords = playerOneShips[x][y].getXCords();
      int[] yCords = playerOneShips[x][y].getYCords();
      
      if(playerOneShips[xCords[0]][yCords[0]].getHit() && playerOneShips[xCords[1]][yCords[1]].getHit() && playerOneShips[xCords[2]][yCords[2]].getHit())
      {
         return true;
      }
      
      return false;
   }
   
   public static boolean allBoxesAtkedPlayerTwoShips(int x, int y)
   {
      int[] xCords = playerTwoShips[x][y].getXCords();
      int[] yCords = playerTwoShips[x][y].getYCords();
      
      if(playerTwoShips[xCords[0]][yCords[0]].getHit() && playerTwoShips[xCords[1]][yCords[1]].getHit() && playerTwoShips[xCords[2]][yCords[2]].getHit())
      {
         return true;
      }
      
      return false;
   }
      
}
