package ss.week6.ttt;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TTTView implements Observer{
	private JFrame frame;
	private Button[] boardButtons = new Button[Board.DIM * Board.DIM];
	private Label infoLabel;
	private Button continueButton;
	
	public TTTView(Game game){
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		
		//panel that holds the field, info label and continue button
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);
		
		JPanel gridPanel = new JPanel(new GridLayout(3, 3));
		panel.add(gridPanel);
		
		for(int i = 0; i < boardButtons.length; i++){
			Button button = new Button(Mark.EMPTY.toString());
			boardButtons[i] = button;
			gridPanel.add(button);
		}
		
		infoLabel = new Label();
		panel.add(infoLabel);
		
		continueButton = new Button("Play Again?");
		panel.add(continueButton).setEnabled(false);
		
		new TTTController(game);
		
		frame.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg){
		System.out.println("asdlfwae");
		
		Game game = (Game) o;
		Board board = game.getBoard();
		
		for(int i = 0; i < boardButtons.length; i++){
			boardButtons[i].setLabel(board.getField(i).toString());
		}
		
		if(board.gameOver()){
			if(board.isWinner(Mark.OO)) infoLabel.setText("O has won");
			else if(board.isWinner(Mark.XX)) infoLabel.setText("X has won");
			else infoLabel.setText("Draw");
		}else{
			if(game.getCurrent() == Mark.OO) infoLabel.setText("O's turn");
			else infoLabel.setText("X's turn");
		}
		
		continueButton.setEnabled(board.gameOver());
	}
	
	private class TTTController implements ActionListener{
		private final Game game;
		
		private TTTController(Game game){
			this.game = game;
			
			for(Button b : boardButtons){
				b.addActionListener(this);
			}
			
			continueButton.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e){
			//find the index
			for(int i = 0; i < boardButtons.length; i++){
				if(boardButtons[i] == e.getSource()){
					if(game.getBoard().getField(i) == Mark.EMPTY){
						game.takeTurn(i);
						game.notifyObservers();
					}
					
					break;
				}
			}
			
			if(e.getSource() == continueButton){
				game.reset();
				game.notifyObservers();
			}
		}
	}
	
	public static void main(String[] args){
		Game game = new Game();
		TTTView view = new TTTView(game);
		game.addObserver(view);
	}
}
