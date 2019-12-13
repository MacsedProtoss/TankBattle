package group.Macsed.TankBattle.Scene.portable.extension.Time;

import java.util.ArrayList;

import group.Macsed.TankBattle.Scene.portable.Base.GameBullet;
import group.Macsed.TankBattle.Scene.portable.main.Demo;

public class BulletTime extends Thread {
	public void run() {
		while (true) {

			ArrayList<GameBullet> gameBullet = Demo.gameDataManager.getGameBullet();
			for (int i = 0; i < gameBullet.size(); i++) { // 获取游戏中所有的子弹
				GameBullet b = gameBullet.get(i);
				// b.move(); // 调用移动方法
				b.touchMap(b, Demo.gameDataManager.getMap());

			}
			for (int i = 0; i < gameBullet.size(); i++) { // 获取游戏中所有的子弹
				GameBullet b = gameBullet.get(i);
				if (b.getBy() < 0 || b.getBy() > 600 || b.getBx() < 0 || b.getBx() > 600) {
					gameBullet.remove(i); // 删除子弹
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
