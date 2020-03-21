package become_a_farmer_0320;

import javax.swing.JLabel;

public class PlayerMoney extends Thread{
	
	static int money = 10000;
	
    JLabel player_money = new JLabel();
    
    public PlayerMoney(JLabel player_money)
    {
        this.player_money = player_money;
    }
    
    public void run()
    	{
    		money -= 10;
    		player_money.setText("         G: "+money);
            System.out.println(money);
    }
}