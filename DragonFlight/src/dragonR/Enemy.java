package dragonR;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Movable {

//	0이면 죽은상태, 1이면 살아있는 상태
	private int state;

//	적군 위치
	private int x;
	private int y;

//	움직임 상태
	private boolean down;

//	적군 속도
	private final int SPEED = 3;
//	Random random = new Random();

	private ImageIcon enemy;

	public Enemy() {
		initData();
		setInitLayout();
		
	}=new ImageIcon("images/whiteE.png").getImage();

	int x, y;
	int width = image.getWidth(null);
	int height = image.getHeight(null);
	int hp = 5; // 원래 10

	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move() {
		this.y += 7;
	}
}
