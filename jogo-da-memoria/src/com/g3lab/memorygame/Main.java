package com.g3lab.memorygame;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	private Game game;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Main() {
		game = new Game();
		add(game);
		setBackground(new Color(238, 238, 238));
		setSize(410, 430);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle(":D");
	}

	public static void main(String[] args) {
		final Main main = new Main();
		new Thread() {

			@Override
			public void run() {
				while (true) {
					if (main.getGame().valida())
						break;
				}
				JOptionPane.showMessageDialog(main, "Ganhou!");
				main.hide();
			}

		}.start();

	}

}
