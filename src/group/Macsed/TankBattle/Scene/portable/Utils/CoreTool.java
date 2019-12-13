package group.Macsed.TankBattle.Scene.portable.Utils;

import java.util.Random;

import javax.swing.ImageIcon;

import group.Macsed.TankBattle.Scene.portable.Base.GameBomp;
import group.Macsed.TankBattle.Scene.portable.main.Demo;

import group.Macsed.TankBattle.Scene.portable.Base.Tank.EnemyTank;


public class CoreTool {
	static void paint(String path, int x, int y, int w, int h) { // 绘制图片
		ImageIcon ii2 = new ImageIcon(path);
		Demo.hf2.getPanel().getGraphics().drawImage(ii2.getImage(), x, y, w, h, Demo.hf2);
	}

	static public void bomp(int x, int y) {
		Demo.gameDataManager.gameBomps.add(new GameBomp(x, y));
	}

	static public void make_tank(int kind) { // 敌方坦克工厂
		int[][] map = Demo.gameDataManager.map;
		Random random = new Random();
		int x;
		int y;
		while (true) {
			x = random.nextInt(15);
			y = random.nextInt(10);
			if (map[y][x] == 0 || map[y][x] == 1)
				break;
		}
		int dir = random.nextInt(4);
		Demo.gameDataManager.list3.add(new EnemyTank(x * 40, y * 40, dir, kind));
	}
}
