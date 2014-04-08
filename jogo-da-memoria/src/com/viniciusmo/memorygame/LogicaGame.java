package com.viniciusmo.memorygame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class LogicaGame extends MouseAdapter {
	private Square selected;
	private final JPanel panel;
	private Square[][] squares;

	public LogicaGame(JPanel panel, Square[][] squares) {
		this.panel = panel;
		this.squares = squares;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = e.getY() / 100;
		int j = e.getX() / 100;
		final Square sClick = squares[i][j];
		
		if (!sClick.isBlock() && !sClick.isClicado()) {
			sClick.setClicado(true);
			if (selected != null) {
				panel.removeMouseListener(this);
				new Thread() {
					@Override
					public void run() {
						try {
							panel.repaint();
							Thread.sleep(500);
							if (selected.getPos() == sClick.getPos()) {
								sClick.setBlock(true);
								selected.setBlock(true);

							} else {
								sClick.setClicado(false);
								selected.setClicado(false);
								panel.repaint();
							}
							selected = null;
							panel.addMouseListener(LogicaGame.this);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}.start();

			} else {
				selected = sClick;
				panel.repaint();
			}

		}
	}

}
