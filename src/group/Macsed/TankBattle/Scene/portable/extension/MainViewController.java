package group.Macsed.TankBattle.Scene.portable.extension;

import javax.swing.JOptionPane;

import group.Macsed.TankBattle.Scene.portable.Utils.CoreTool;
import group.Macsed.TankBattle.Scene.portable.main.Demo;

public class MainViewController { // 关卡得分配置;
	int tk_num; // 捍卫者人数
	int assa_num; // 偷袭者人数
	int attck_num; // 狙击手人数
	int stage; // 目前属于的关卡
	public int grade = 0;
	public int kill_num = 0;
	int grade_stage = 0;
	int kill_stage = 0;
	public boolean painting = false;
	public boolean jumping = false;

	public boolean run = false;
	// 1草地，2铁墙，3砖头，4国王，5水，
	static int[][] map1 = { // 第一关
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 },
			{ 0, 0, 0, 2, 3, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 5, 0, 0, 5, 5, 5, 0, 0, 5, 5, 0, 0, 5, 5, 5 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 }, { 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 }, { 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0 } };
	static int[][] map2 = { // 第二关
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 2 },
			{ 0, 0, 0, 2, 3, 0, 0, 0, 3, 2, 1, 1, 2, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 2, 0, 3, 1, 1, 2, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 2, 0, 3, 1, 1, 1, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 2, 0, 0, 1, 1, 2, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 5, 0, 0, 5, 5, 5, 0, 0, 5, 5, 0, 0, 5, 5, 5 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 5, 1, 0, 0, 0 }, { 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 3, 0, 0, 0, 0, 0, 3, 5, 0, 0, 1, 0 }, { 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 5, 0, 0, 1, 0 },
			{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 5, 0, 2, 1, 2 }, { 0, 0, 0, 0, 0, 3, 2, 2, 0, 0, 5, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 3, 4, 3, 0, 0, 5, 0, 0, 0, 0 } };
	static int[][] map3 = { // 第三关
			{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0 }, { 2, 0, 3, 3, 3, 0, 0, 5, 3, 0, 3, 0, 2, 2, 2 },
			{ 2, 0, 0, 3, 3, 0, 0, 5, 3, 3, 0, 0, 0, 0, 0 }, { 0, 1, 0, 3, 0, 0, 0, 5, 3, 3, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 3, 0, 0, 0, 5, 3, 3, 3, 0, 0, 0, 0 }, { 0, 1, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 1, 3, 0, 2, 0, 0, 0, 0, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 1, 1, 0, 0 },
			{ 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0 },
			{ 0, 0, 1, 3, 0, 0, 0, 0, 3, 3, 0, 0, 3, 0, 0 }, { 0, 0, 1, 2, 0, 2, 2, 2, 3, 2, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 5, 5, 0, 2, 2, 2 }, { 2, 0, 0, 0, 0, 3, 3, 3, 0, 0, 5, 0, 0, 0, 0 },
			{ 4, 0, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0 } };

	public MainViewController() {
	}

	private void prepare_chage_stage() {
		// 为准备切换关卡做好准备
		tk_num = 10;
		assa_num = 10;
		attck_num = 10; // 重置人数
		kill_stage = 0; // 关卡数据清空
		grade_stage = 0;
		Demo.gameDataManager.gameBomps.clear();
		Demo.gameDataManager.gameBullet.clear();
		Demo.gameDataManager.list.get(0).setTx(100);
		Demo.gameDataManager.list.get(0).setTy(500);
		Demo.gameDataManager.list2.clear();
		Demo.gameDataManager.list3.clear();
		// 重置敌方坦克，我方坦克，子弹，移除所有未炸完的爆炸
	}

	public void change_stage(int map) {
		while (Demo.mainViewController.painting) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		stage = 1;
		prepare_chage_stage();
		int[][] new_map = null;
		switch (map) {
		case 1:
			new_map = map1;
			break;
		case 2:
			new_map = map2;
			break;
		case 3:
			new_map = map3;
			break;
		default:
			break;
		}
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				Demo.gameDataManager.map[i][j] = new_map[i][j];
			}
		}
		CoreTool.make_tank(1); // 先刷个三个出来
		CoreTool.make_tank(2);
		CoreTool.make_tank(3);
		CoreTool.make_tank(1); // 先刷个三个出来
		CoreTool.make_tank(2);
		CoreTool.make_tank(3);
		CoreTool.make_tank(1); // 先刷个三个出来
		CoreTool.make_tank(2);
		CoreTool.make_tank(3);
		CoreTool.make_tank(1); // 先刷个三个出来
		CoreTool.make_tank(2);
		CoreTool.make_tank(3);
		setStatus();
	}

	public void enemy_tank_died(int kind) {
		setStatus();
		grade_stage += kind;
		kill_num++;
		grade += kind;
		kill_stage++;
		// 敌人死掉后我方需要做出的改变
		switch (kind) {
		case 1: // 死了一个狙击手
			attck_num--;
			if (attck_num > 0) // 有存量的话的造一个
			{
				CoreTool.make_tank(1);
			}
			break;

		case 2:
			tk_num--;
			if (tk_num > 0) // 有存量的话的造一个
			{
				CoreTool.make_tank(2);
			}
			break;
		case 3:
			assa_num--;
			if (assa_num > 0) // 有存量的话的造一个
			{
				CoreTool.make_tank(3);
			}
			break;
		default:
			break;
		}
		if (attck_num == 0 && tk_num == 0 && assa_num == 0) {
			// 这张地图上敌人杀光了
			if (stage == 3) { // 没有下一关了{
				// TODO success
			} else {
				change_stage(stage + 1); // 下一关
			}
		}
	}

	public void fail() {
		Demo.mainViewController.change_stage(1);
		Demo.mainViewController.run = false;
		Demo.mainViewController.grade = 0;
		Demo.mainViewController.kill_num = 0;
		JOptionPane.showMessageDialog(null, "Try Again!", "Defeat", JOptionPane.OK_OPTION);
		Demo.mainViewController.run = true;
	}

	public void success() {
		JOptionPane.showMessageDialog(null, "You win", "Victory", JOptionPane.OK_OPTION);
		System.exit(0);
	}

	public void setStatus() { // 设置侧边栏
		Demo.hf2.getPanel().tank_num.setText(String.format("attacker:%d defender:%d holder:%d", tk_num, assa_num, attck_num));
		Demo.hf2.getPanel().kill.setText("killed tanks:" + Integer.toString(kill_stage));
		Demo.hf2.getPanel().kill_all.setText("all killed tanks:" + Integer.toString(kill_num));
		Demo.hf2.getPanel().grade.setText("score:" + Integer.toString(grade_stage));
		Demo.hf2.getPanel().grade_all.setText("all score:" + Integer.toString(grade));

	}

}
