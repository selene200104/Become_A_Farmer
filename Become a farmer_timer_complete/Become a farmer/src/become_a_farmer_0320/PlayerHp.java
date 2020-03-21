package become_a_farmer_0320;

import javax.swing.JLabel;

public class PlayerHp extends Thread{
	
	static int hp = 100;
	
    JLabel player_hp = new JLabel();
    
    public PlayerHp(JLabel player_hp)
    {
        this.player_hp = player_hp;
    }
    
    public void run()
    	{
            hp -= 10;
            player_hp.setText("         Ã¼·Â: "+hp);
            System.out.println(hp);
    }
}
