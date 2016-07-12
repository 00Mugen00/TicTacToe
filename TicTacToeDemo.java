package prTicTacToe;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToeDemo {
	public static void main(String[] args){
		TicTacToeView ticTacToeView = new TicTacToePanel();
		TicTacToeCtr ticTacToeCtr= new TicTacToeCtr(ticTacToeView);
		ticTacToeView.controller(ticTacToeCtr);
		JFrame window = new JFrame("TicTacToe");  	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane((JPanel) ticTacToeView);		 
		window.pack();	
		window.setVisible(true);
		window.setResizable(false);
		
		ImageIcon img = new ImageIcon("logo.png");
		window.setIconImage(img.getImage());
	}
}
