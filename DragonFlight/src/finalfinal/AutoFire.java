package finalfinal;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Background.BackgroundFireService;
import Background.GameFrame;

public class AutoFire extends JLabel implements Movable {

//	화염 위치
	private int x;
	private int y;

//	화염 방향
	private boolean up;

//	적군 맞췄는지
	private int state;

	private ImageIcon autoFire;

	private GameFrame mContext;

	private Player player;

	private BackgroundFireService backgroundFireService;

	public AutoFire(GameFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		backgroundFireService = new BackgroundFireService(this);
		initThread();
	}

	private void initData() {
		autoFire = new ImageIcon("images/Fire_Nella.png");
		up = false;
		state = 0;
	}

	private void setInitLayout() {
		x = mContext.getPlayer().getX();
		y = mContext.getPlayer().getY();
		setIcon(autoFire);
		setSize(30, 30);
		setLocation(x, y);
	}

	private void initThread() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				if(mContext.get)
//			}
//		}).start();

	}

	@Override
	public void up() {
		up = true;
		while(up) {
			y--;
			setLocation(x, y);
			if(backgroundFireService.topWall()) {
				setIcon(null);
				break;
			}
//			스레드 시간이 필요한가 나중에 확인
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public void crash() {
		mContext.getEnemy().setState
	}

}  // end of class
