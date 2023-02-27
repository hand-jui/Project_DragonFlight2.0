package finalfinal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;
//	private Enemy[] ememies = new Enemy[5];


//	private int 

	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		try {
			image = ImageIO.read(new File("images/backgroundService.png"));
		} catch (IOException e) {
			System.out.println("백그라운드플레이어서비스객체에 사용하는 이미지 경로 및 파일명 확인");
		}
	}

	@Override
	public void run() {
		while (enemy.getState() == 0) {
			for (int i = 0; i < enemy; i++) {
				Color bottomColor = new Color(image.getRGB(enemy_x[i].getEnemy_x(), enemy.getEnemy_y()));

			}
		} // end of while
	}

}
