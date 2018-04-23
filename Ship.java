
public class Ship {
   private int[] xCords;
   private int[] yCords;
   private boolean hit = false;

   public Ship(int[] storeX, int[] storeY) {
      xCords = storeX;
      yCords = storeY;
   }

   public int[] getXCords()
   {
      return xCords;
   }
   
   public int[] getYCords()
   {
      return yCords;
   }
   
   public void setHit()
   {
      hit = true;
   }
   
   public boolean getHit()
   {
      return hit;
   }
}
