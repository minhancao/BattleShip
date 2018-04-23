
public class BattleShip 
{
    public static void main(String[] args) 
    {
       PlayerScreen play1 = new PlayerScreen("Player1", true);
       PlayerScreen play2 = new PlayerScreen("Player2", false);
       play1.receivePlayer(play2);
       play2.receivePlayer(play1);
        State state = new State(play1, play2);
    }
}