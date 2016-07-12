package prTicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeCtr implements ActionListener{
	private TicTacToeView view;
	private int player;
	public TicTacToeCtr(TicTacToeView view){
		this.view=view;
		this.player=0;
	}
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		int tileNumber=Integer.parseInt(command);
		if(view.changeImage(player,tileNumber)){
			//ChangeImage() return true if the game has ended
			player=0;
		}else{
			player=(player+1)%2;
		}
	}
}
