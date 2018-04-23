import java.awt.Color;

import javax.swing.JFrame;

public class State {
   static int state = 0; //0 = p1 setup, 1 = p2 setup, 2 = p1 turn, 3 = p2 turn, 4 = game over
   static PlayerScreen one;
   static PlayerScreen two;
   
   public State(PlayerScreen one, PlayerScreen two) {
      this.one = one;
      this.two = two;
   }
   
   public static void next(int stateNum)
   {
      state = stateNum;
      switch(state)
      {
         //p1setup
         case 0: 
            break;
         
         //p2setup
         case 1: 
            one.hideScreen();
            two.showScreen();
            break;
         
         //p1turn
         case 2: 
            two.hideScreen();
            one.showScreen();
            break;
         
         //p2turn
         case 3: 
            one.hideScreen();
            two.showScreen();
            break;
         
         //p1win
         case 4: 
            one.showScreen();
            two.hideScreen();
            break;
         
         //p2win
         case 5: 
            one.hideScreen();
            two.showScreen();
            break;
         
         //close game
         case 6: 
            one.dispose();
            two.dispose();
            break;
      }
   }
   
   public static int returnCurrentState()
   {
      return state;
   }

}
