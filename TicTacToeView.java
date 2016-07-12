package prTicTacToe;

import java.awt.event.ActionListener;

public interface TicTacToeView {
	void controller(ActionListener ctr);
	boolean changeImage(int player,int tileNumber);
}
