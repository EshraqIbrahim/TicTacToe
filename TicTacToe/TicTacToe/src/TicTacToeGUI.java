import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container pane;
	private String currentPlayer;
	private JButton[][] board;
	private boolean isWinner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem quit;
	private JMenuItem newGame;
	
	public TicTacToeGUI(){
		super();
		pane = getContentPane();
		pane.setLayout(new GridLayout(3,3));
		setTitle("Tic Tac Toe");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		currentPlayer="X";
		board = new JButton[3][3];
		isWinner = false;
		intializeBoard();
		intializeMenuBar();
	}
	public void intializeMenuBar(){
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				resetBoard();
			}
		
		});
		
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	public void resetBoard(){
		currentPlayer = "X";
		isWinner = false;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				board[i][j].setText("");
			}
		}
		
	}
	public void intializeBoard(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				JButton btn = new JButton();
				btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
				board[i][j] = btn;
				btn.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(((JButton) e.getSource()).getText().equals("")&&(isWinner == false)){
							btn.setText(currentPlayer);
							hasWinner();
							togglePlayer();
						}
					}
					
				});
				pane.add(btn);
			}
		}
	}
	public void togglePlayer(){
		if(currentPlayer == "X"){
			currentPlayer ="O";
		}
		else{
			currentPlayer ="X";
		}
	}
	private void hasWinner(){
		if(board[0][0].getText().equals(currentPlayer)
				&&board[0][1].getText().equals(currentPlayer)&&board[0][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[1][0].getText().equals(currentPlayer)
				&&board[1][1].getText().equals(currentPlayer)&&board[1][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[2][0].getText().equals(currentPlayer)
				&&board[2][1].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HASWON");
			isWinner = true;
		}
		else if(board[0][0].getText().equals(currentPlayer)
				&&board[1][0].getText().equals(currentPlayer)&&board[2][0].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[0][1].getText().equals(currentPlayer)
				&&board[1][1].getText().equals(currentPlayer)&&board[2][1].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[0][2].getText().equals(currentPlayer)
				&&board[1][2].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[0][0].getText().equals(currentPlayer)
				&&board[1][1].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		else if(board[0][2].getText().equals(currentPlayer)
				&&board[1][1].getText().equals(currentPlayer)&&board[2][0].getText().equals(currentPlayer)){
			JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\n"+"THE PLAYER "+currentPlayer+" HAS WON");
			isWinner = true;
		}
		
		
	}
	
}
