package com.viniciusmo.memorygame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.viniciusmo.memorygame.utils.Generate;

public class Game extends JPanel implements Valida {
	private static final long serialVersionUID = 1L;
	private Square[][] squares;
	private LogicaGame logic;

	public Game() {
		setSize(400, 405);
		squares = new Square[4][4];
		logic = new LogicaGame(this, squares);
		addMouseListener(logic);
		initSquares();

	}


	private void initSquares() {
		Queue<Integer> generate = Generate.randomSequence(8);
		Generate.randomSequence(generate, 8);
		int pos = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Square s = new Square();
				pos = generate.remove();
				ImageIcon ii = new ImageIcon(this.getClass().getResource(
						"images/" + pos + ".png"));
				s.setImage(ii.getImage());
				s.setPos(pos);
				s.setX(j * 100);
				s.setY(i * 100);
				s.setMyX(i);
				s.setMyY(j);
				squares[i][j] = s;
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0, 0, 0));

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Square s = squares[i][j];
				g2.drawImage(s.getImage(), s.getX(), s.getY(), this);
			}
		}
	}

	@Override
	public boolean valida() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (!squares[i][j].isBlock()) {
					return false;
				}
			}
		}
		return true;
	}

}
