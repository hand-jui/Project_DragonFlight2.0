package finalfinal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Background.GameFrame;

public class Player extends JLabel implements Movable {

	GameFrame mContext;

//	플레이어 이미지
	private ImageIcon player;

//	플레이어 생성위치
	private int x;
	private int y;

//	플레이어의 속도
	private final int SPEED = 10;

//	플레이어의 현재 움직임
	private boolean left;
	private boolean right;

//	벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	private boolean isAttack;
//	run 메서드 내부에 while 실행시키는 flag
	private boolean isOver; // 게임 오버

	public Player(GameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	public GameFrame getmContext() {
		return mContext;
	}

	public void setmContext(GameFrame mContext) {
		this.mContext = mContext;
	}

	public ImageIcon getPlayer() {
		return player;
	}

	public void setPlayer(ImageIcon player) {
		this.player = player;
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

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public boolean isAttack() {
		return isAttack;
	}

	public void setAttack(boolean isAttack) {
		this.isAttack = isAttack;
	}

	public boolean isOver() {
		return isOver;
	}

	public void setOver(boolean isOver) {
		this.isOver = isOver;
	}

	public int getSPEED() {
		return SPEED;
	}

	private void initData() {
		player = new ImageIcon("images/player1.png");

		left = false;
		right = false;

		leftWallCrash = false;
		rightWallCrash = false;
	}

	private void setInitLayout() {
		x = 225;
		y = 720;

		setSize(150, 150);
		setLocation(x, y);
		setIcon(player);
	}

	@Override
	public void left() {
		left = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // end of while
			}
		}).start();
	}

	@Override
	public void right() {
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	public void attack() {
		AutoFire autoFire = new AutoFire();
	}
//	private Attack attack;
//	private ArrayList<Attack> attackList = new ArrayList<>();

}
