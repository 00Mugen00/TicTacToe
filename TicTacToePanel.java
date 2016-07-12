package prTicTacToe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToePanel extends JPanel implements TicTacToeView{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ImageIcon image1 = new ImageIcon("X.png");
	private static ImageIcon image2 = new ImageIcon("O.png");
	private JButton[] buttons;
	private int[] tile;
	private JLabel message;
	public TicTacToePanel(){
		buttons = new JButton[9];
		tile=new int[9];
		for(int i=0; i<9; i++){
			buttons[i]=new JButton("");
			buttons[i].setPreferredSize(new Dimension(128,128));
			tile[i]=-1;
		}
		message = new JLabel("Game in Progress");
		
		setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,3));
		for(int i=0; i<9; i++){
			centerPanel.add(buttons[i]);
		}
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,1));
		southPanel.add(message);
		
		add(centerPanel,BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
	}
	public void controller(ActionListener ctr) {
		for(int i=0; i<9; i++){
			buttons[i].addActionListener(ctr);
			buttons[i].setActionCommand(Integer.toString(i));
		}
	}
	public boolean changeImage(int player, int tileNumber) {
		if(!message.getText().equals("Game in Progress")){
			message.setText("Game in Progress");
		}
		if(player==0){
			buttons[tileNumber].setIcon(image1);
		}else{
			buttons[tileNumber].setIcon(image2);
		}
		tile[tileNumber]=player;
		buttons[tileNumber].setEnabled(false);
		if(isWinner(player)){
			message.setText("Player "+player+" is the winner");
			for(int i=0; i<9; i++){
				buttons[i].setIcon(new ImageIcon());
				buttons[i].setEnabled(true);
				tile[i]=-1;
			}
			return true;
		}else{
			if(allDisabled()){
				message.setText("It's a Draw");
				for(int i=0; i<9; i++){
					buttons[i].setIcon(new ImageIcon());
					buttons[i].setEnabled(true);
					tile[i]=-1;
				}
				return true;
			}
			return false;
		}
	}
	
	private boolean allDisabled(){
		boolean result=true;
		for(int i=0; i<9; i++){
			result= result&&!buttons[i].isEnabled();
		}
		return result;
	}
	
	private boolean isWinner(int player) {
		boolean result=false;
		result=checkRow(0,player)||checkRow(1,player)||checkRow(2,player)||checkColumn(0,player)||checkColumn(1,player)||checkColumn(2,player)||checkDiagonal(0,player)||checkDiagonal(1,player);
		return result;
	}
	private boolean checkRow(int i,int player){
		if(i==0){
			return player==tile[0]&&tile[0]==tile[1]&&tile[1]==tile[2];
		}else if(i==1){
			return player==tile[3]&&tile[3]==tile[4]&&tile[4]==tile[5];
		}else if(i==2){
			return player==tile[6]&&tile[6]==tile[7]&&tile[7]==tile[8];
		}
		return false;
	}
	private boolean checkColumn(int i,int player){
		if(i==0){
			return player==tile[0]&&tile[0]==tile[3]&&tile[3]==tile[6];
		}else if(i==1){
			return player==tile[1]&&tile[1]==tile[4]&&tile[4]==tile[7];
		}else if(i==2){
			return player==tile[2]&&tile[2]==tile[5]&&tile[5]==tile[8];
		}
		return false;
	}
	private boolean checkDiagonal(int i,int player){
		if(i==0){
			return player==tile[0]&&tile[0]==tile[4]&&tile[4]==tile[8];
		}else if(i==1){
			return player==tile[2]&&tile[2]==tile[4]&&tile[4]==tile[6];
		}
		return false;
	}
}
