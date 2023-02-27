package finalfinal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dragonR.AutoFire;

public class BackgroundFireService {

	private BufferedImage image;
	private AutoFire autoFire;
	
	public BackgroundFireService(AutoFire autoFire) {
		this.autoFire = autoFire;
		try {
			image = ImageIO.read(new File("images/background3.png"));
		} catch (IOException e) {
			System.out.println("백그라운드서비스객체에 사용하는 이미지 경로 및 파일명 확인");
		}
		
		
	}
	
	public boolean topWall() {
		Color topColor = new Color(image.getRGB(autoFire.getX(), autoFire.getY()));
		if(topColor.getRed()==255&& topColor.getGreen()==0&& topColor.getBlue()==0) {
			return true;
		}
		return false;
	}
}
