package group.macsed.commonPort.portable.extension.Time;

import java.util.ArrayList;

import group.macsed.commonPort.portable.Base.Tank.EnemyTank;;
import group.macsed.commonPort.portable.main.Demo;

public class EnemyTime extends Thread {

	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (Demo.mainViewController.run == true)
				break;
		}
		while (true) {

			ArrayList<EnemyTank> et = Demo.gameDataManager.getList3();
			for (int i = 0; i < et.size(); i++) { // 获取游戏中所有的地方坦克
				et.get(i).touchMap(Demo.gameDataManager.map); // 调用移动方法

			}
			for (int i = 0; i < et.size(); i++) { // 获取游戏中所有的地方坦克
				if (et.get(i).getEty() < 0 || et.get(i).getEty() > 600 || et.get(i).getEtx() < 0
						|| et.get(i).getEtx() > 600) {
					et.remove(i); // 删除这辆坦克 死掉了
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
