//This program creates a game of TIC-TAC-TOE 

package ticTac;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacGUI extends JFrame {
	JPanel p;
	JButton[] buttons;
	int turn;

	public TicTacGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p = new JPanel();
		buttons = new JButton[9];
		turn = 0;
		setSize(400, 400);
		setTitle("TIC-TAC-TOE");
		p.setLayout(new GridLayout(3, 3));
		for (int i = 0; i <= 8; i++) {
			buttons[i] = new JButton();
			buttons[i].setText("");
			buttons[i].addActionListener(new determineButton());
			p.add(buttons[i]);
		}

		setLocationRelativeTo(null);

		add(p);

		setVisible(true);
	}
//action listener used to determine which button has been selected
	private class determineButton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i <= 8; i++) {
				if (buttons[i] == e.getSource()) {
					determineXorO(buttons[i]);

				}

			}

		}
	}
//method used to switch from player 'X' and player'O'
	private void determineXorO(JButton b) {
		if (turn % 2 == 0) {
			b.setText("X");
			b.setEnabled(false);
			checkWinner();
			turn++;
		} else {
			b.setText("O");
			b.setEnabled(false);
			checkWinner();
			turn++;
		}

	}

	//checks every possiblity to determine if a player has won.
	private void checkWinner() {
		String b1 = buttons[0].getText();
		String b2 = buttons[1].getText();
		String b3 = buttons[2].getText();
		String b4 = buttons[3].getText();
		String b5 = buttons[4].getText();
		String b6 = buttons[5].getText();
		String b7 = buttons[6].getText();
		String b8 = buttons[7].getText();
		String b9 = buttons[8].getText();

		if (b1 != "" & b2 != "" & b3 != "" & b1 == b2 & b2 == b3 & b1 == b3) {
			JOptionPane.showMessageDialog(null, "Player " + b1 + " WINS!");
			reset();
		} else if (b4 != "" & b5 != "" & b6 != "" & b4 == b5 & b5 == b6 & b4 == b6) {
			JOptionPane.showMessageDialog(null, "Player " + b4 + " WINS!");
			reset();
		} else if (b7 != "" & b8 != "" & b9 != "" & b7 == b8 & b8 == b9 & b7 == b9) {
			JOptionPane.showMessageDialog(null, "Player " + b7 + " WINS!");
			reset();
		}

		else if (b1 != "" & b4 != "" & b7 != "" & b1 == b4 & b4 == b7 & b1 == b4) {
			JOptionPane.showMessageDialog(null, "Player " + b7 + " WINS!");
			reset();
		} else if (b2 != "" & b5 != "" & b8 != "" & b2 == b5 & b5 == b8 & b2 == b8) {
			JOptionPane.showMessageDialog(null, "Player " + b2 + " WINS!");
			reset();
		} else if (b3 != "" & b6 != "" & b9 != "" & b3 == b6 & b6 == b9 & b3 == b9) {
			JOptionPane.showMessageDialog(null, "Player " + b3 + " WINS!");
			reset();
		}

		else if (b1 != "" & b5 != "" & b9 != "" & b1 == b5 & b5 == b9 & b1 == b9) {
			JOptionPane.showMessageDialog(null, "Player " + b1 + " WINS!");
			reset();
		} else if (b3 != "" & b5 != "" & b7 != "" & b3 == b5 & b5 == b7 & b3 == b7) {
			JOptionPane.showMessageDialog(null, "Player " + b3 + " WINS!");
			reset();
		}
	}
// disposes of the old GUI after game is over, begins a new game
	private void reset() {
		dispose();
		new TicTacGUI();
	}

}
