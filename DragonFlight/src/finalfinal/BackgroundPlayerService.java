package finalfinal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dragonR.Player;

public class BackgroundPlayerService implements Runnable{
	
	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player = player;
		try {
			image = ImageIO.read(new File("images/background3.png"));
		} catch (IOException e) {
			System.out.println("백그라운드플레이어서비스객체에 사용하는 이미지 경로 및 파일명 확인");
		}
	}
	@Override
	public void run() {
		while(true) {
			Color leftColor = new Color(image.getRGB(player.getX(), player.getY()));
			Color rightColor = new Color(image.getRGB(player.getX(), player.getY()));
			if(rightColor.getRed()==255&&rightColor.getGreen()==0&&rightColor.getBlue()==0) {
				player.setRight(false);
				player.setRightWallCrash(true);
			} else if (leftColor.getRed()==255&&leftColor.getGreen()==0&&leftColor.getBlue()==0) {
				player.setLeft(false);
				player.setLeftWallCrash(true);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}  // end of while
		
		
	}

}
