package finalfinal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Movable {

	private GameFrame mContext;

//	0이면 죽은상태, 1이면 살아있는 상태
	private int state;

//	적군 위치
	private int enemy_x;
	private int enemy_y;

//	움직임 상태
	private boolean down;

//	적군 속도
	private final int SPEED = 3;
//	Random random = new Random();

	private ImageIcon enemy;

	int hp = 5;

	public Enemy(GameFrame mContext, Boolean down) {
		this.mContext = mContext;
	}

	public Enemy() {
		initData();
		setInitLayout();
		initBackgroundEnemyService();

	}

	public GameFrame getmContext() {
		return mContext;
	}

	public void setmContext(GameFrame mContext) {
		this.mContext = mContext;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getEnemy_y() {
		return enemy_y;
	}

	public void setEnemy_y(int enemy_y) {
		this.enemy_y = enemy_y;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public ImageIcon getEnemy() {
		return enemy;
	}

	public void setEnemy(ImageIcon enemy) {
		this.enemy = enemy;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSPEED() {
		return SPEED;
	}

	private void initData() {
		enemy = new ImageIcon("images/whiteE.png");

		enemy_y = 0;

		down = false;
		state = 1;
	}

	private void setInitLayout() {
		setIcon(enemy);
		setSize(100, 100);
		setLocation(enemy_x, enemy_y);
	}

	private void initBackgroundEnemyService() {
		new Thread(new BackgroundEnemyService(this)).start();
	}

	@Override
	public void down() {
		down = true;
		new Thread(() -> {
			while (down) {
				enemy_y += SPEED;
				setLocation(enemy_x, enemy_y);
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();
		moveDown();
		down = false;
	}

	public void moveDown() {
		this.enemy_y += 7;
	}
}
