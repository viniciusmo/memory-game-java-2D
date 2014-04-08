package com.g3lab.memorygame;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Square implements Cloneable {
	private Image image;
	private int pos;
	private int x;
	private int y;
	private int myX;
	private int myY;
	private boolean clicado;
	private boolean block;

	public Image getImage() {
		if (clicado) {
			return image;
		}
		return new ImageIcon(this.getClass().getResource("images/back.png"))
				.getImage();
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMyX() {
		return myX;
	}

	public void setMyX(int myX) {
		this.myX = myX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int myY) {
		this.myY = myY;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean isClicado() {
		return clicado;
	}

	public void setClicado(boolean clicado) {
		this.clicado = clicado;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

}
