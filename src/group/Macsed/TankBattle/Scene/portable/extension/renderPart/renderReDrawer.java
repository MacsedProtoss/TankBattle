package group.Macsed.TankBattle.Scene.portable.extension.renderPart;

import group.Macsed.TankBattle.Scene.portable.main.Demo;

public class renderReDrawer extends Thread {
	public void run() {
		while (true) {
			Demo.hf2.getPanel().repaint();// 刷新
			Demo.hf.getHop().repaint();
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
