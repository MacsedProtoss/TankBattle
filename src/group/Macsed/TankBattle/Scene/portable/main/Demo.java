package group.Macsed.TankBattle.Scene.portable.main;

import group.Macsed.TankBattle.Scene.portable.Base.GameDataManager;
import group.Macsed.TankBattle.Scene.portable.extension.HomeView.HomAction;
import group.Macsed.TankBattle.Scene.portable.extension.HomeView.HomKey;
import group.Macsed.TankBattle.Scene.portable.extension.HomeView.HomWindow;
import group.Macsed.TankBattle.Scene.portable.extension.MainViewController;
import group.Macsed.TankBattle.Scene.portable.extension.Time.BulletTime;
import group.Macsed.TankBattle.Scene.portable.extension.renderPart.renderReDrawer;
import group.Macsed.TankBattle.Scene.portable.view.GameFrame;
import group.Macsed.TankBattle.Scene.portable.view.LoginFrame;

import group.Macsed.TankBattle.Scene.portable.extension.Time.EnemyTime;


public class Demo {

	public static GameDataManager gameDataManager = new GameDataManager(); // 全局游戏参数
	public static MainViewController mainViewController = new MainViewController();
	public static HomAction ha = new HomAction(); // 按钮监听
	public static LoginFrame hf = new LoginFrame(); // 登录界面

	public static GameFrame hf2 = new GameFrame(); // 游戏界面 包括菜单栏和 游戏界面
	public static HomWindow hW = new HomWindow(); // 窗体的监听
	public static HomKey hk = new HomKey(); // 按键监听
	public static EnemyTime et = new EnemyTime(); // 控制物体移动 敌人
	public static BulletTime bt = new BulletTime(); // 控制子弹移动
	public static renderReDrawer rpRenderReDrawer = new renderReDrawer(); // 统一控制重绘

	public static void main(String[] args) {
		hf.getHop().getButton().addActionListener(ha); // 按钮监听
		hf.getHop().getButton2().addActionListener(ha);
		hf2.getPanel();
		hf.addWindowListener(hW);// 窗体监听
		hf2.addWindowListener(hW);
		hf2.addKeyListener(hk);
		et.start();
		bt.start();
		rpRenderReDrawer.start();
		mainViewController.change_stage(1);
//		String s = JOptionPane.showInputDialog("请输入ID:");
//		hf2.getPanel().id.setText(s); // 重置id
	}
}
