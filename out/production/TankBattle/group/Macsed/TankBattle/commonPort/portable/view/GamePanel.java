package group.macsed.commonPort.portable.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import group.macsed.commonPort.portable.Base.GameBomp;
import group.macsed.commonPort.portable.Base.GameBullet;
import group.macsed.commonPort.portable.Base.Tank.EnemyTank;
import group.macsed.commonPort.portable.Base.Tank.GameTank;
import group.macsed.commonPort.portable.main.Demo;
import group.macsed.commonPort.portable.Utils.HomePageUtil;

public class GamePanel extends JPanel {

	private JLabel label = new JLabel("Remaining：");
	public JLabel tank_num = new JLabel("Attacker Holder Murderer");
	private JLabel label2 = new JLabel("How to play：");
	private JLabel label3 = new JLabel("up：W");
	private JLabel label4 = new JLabel("down：S");
	private JLabel label5 = new JLabel("left：A");
	private JLabel label6 = new JLabel("right：D");
	private JLabel label7 = new JLabel("attack：space");
	public JLabel kill = new JLabel("attacked tanks");
	public JLabel id = new JLabel("");
	public JLabel grade = new JLabel("got score");
	public JLabel kill_all = new JLabel("killed tanks");
	public JLabel grade_all = new JLabel("final score");
	public Graphics g; // 方便将绘图引擎放出去

	public GamePanel() {
		this.setLayout(null);// 将原本的布局取消掉，我自己定义布局
		label.setBounds(635, 30, 150, 30);
		this.add(label);
		tank_num.setBounds(635, 50, 200, 30);
		this.add(tank_num);
		id.setBounds(635, 170, 60, 30);
		this.add(id);
		label2.setBounds(635, 200, 150, 30);
		this.add(label2);
		label3.setBounds(635, 230, 150, 30);
		this.add(label3);
		label4.setBounds(635, 260, 150, 30);
		this.add(label4);
		label5.setBounds(635, 290, 150, 30);
		this.add(label5);
		label6.setBounds(635, 320, 150, 30);
		this.add(label6);
		label7.setBounds(635, 350, 150, 30);
		this.add(label7);
		kill.setBounds(635, 500, 150, 30);
		this.add(kill);
		grade.setBounds(635, 520, 150, 30);
		this.add(grade);
		kill_all.setBounds(635, 540, 150, 30);
		this.add(kill_all);
		grade_all.setBounds(635, 560, 150, 30);
		this.add(grade_all);

		this.setPreferredSize(new Dimension(HomePageUtil.HOMPANEL2_WIDTH, HomePageUtil.HOMPANEL2_HIGHT));
	}

	@Override
	protected void paintComponent(Graphics g) {
		while (Demo.mainViewController.jumping) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		Demo.mainViewController.painting = true;
		super.paintComponent(g);
		this.g = g;
		// 绘制图片
//		ImageIcon ii = new ImageIcon("img/photo.png");
//		// 2.开始绘制图片,参数：1.图片对象；2,3图片的左上角到原点的距离；4,5图片的尺寸；6.this
//		g.drawImage(ii.getImage(), 0, 0, HomePageUtil.GAME_WIDTH, HomePageUtil.GAME_HIGHT, this);

		// 获取敌方坦克 并画出来
		ArrayList<EnemyTank> list3 = Demo.gameDataManager.getList3();
		for (int i = 0; i < list3.size(); i++) {
			EnemyTank et = list3.get(i);
			String path = "img/e" + list3.get(i).getEdir() + ".png";
			ImageIcon ii3 = new ImageIcon(path);
			g.drawImage(ii3.getImage(), et.getEtx(), et.getEty(), 40, 40, this);
		}

		// 获取坦克并画出来
		ArrayList<GameTank> list = Demo.gameDataManager.getList();
		for (int i = 0; i < list.size(); i++) {
			GameTank t = list.get(i);
			String path = "img/t" + t.getDir() + ".png";
			ImageIcon ii2 = new ImageIcon(path);
			g.drawImage(ii2.getImage(), t.getTx(), t.getTy(), t.getTw(), t.getTh(), this);
		}
		int[][] map = Demo.gameDataManager.getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					String path = "img/tree.jpg"; // 草地
					ImageIcon ii2 = new ImageIcon(path);
					g.drawImage(ii2.getImage(), j * 40, i * 40, 40, 40, this);
				} else if (map[i][j] == 2) {
					String path = "img/stone.jpg"; // 铁墙
					ImageIcon ii2 = new ImageIcon(path);
					g.drawImage(ii2.getImage(), j * 40, i * 40, 40, 40, this);
				} else if (map[i][j] == 3) {
					String path = "img/brick.jpg"; // 砖头
					ImageIcon ii2 = new ImageIcon(path);
					g.drawImage(ii2.getImage(), j * 40, i * 40, 40, 40, this);
				} else if (map[i][j] == 4) {
					String path = "img/nature.png"; // 国王
					ImageIcon ii2 = new ImageIcon(path);
					g.drawImage(ii2.getImage(), j * 40, i * 40, 40, 40, this);
				} else if (map[i][j] == 5) {
					String path = "img/water.png"; // 水
					ImageIcon ii2 = new ImageIcon(path);
					g.drawImage(ii2.getImage(), j * 40, i * 40, 40, 40, this);
				}
			}
		}
		// 获取子弹并画出来
		ArrayList<GameBullet> gameBullet = Demo.gameDataManager.getGameBullet();
		GameBullet b = new GameBullet();
		for (int i = 0; i < gameBullet.size(); i++) {
			GameBullet bu = gameBullet.get(i);
			if (b.getBy() >= 0 || b.getBy() <= 600 || b.getBx() >= 0 || b.getBy() <= 600) {
				ImageIcon ii2 = new ImageIcon("img/bullet.png");
				g.drawImage(ii2.getImage(), bu.getBx(), bu.getBy(), bu.getBw(), bu.getBh(), this);
			}
		}
		// 遍历所有爆炸
		ArrayList<GameBomp> gameBomps = Demo.gameDataManager.gameBomps;
		for (int i = 0; i < gameBomps.size(); i++) {
			ImageIcon ii2 = new ImageIcon(gameBomps.get(i).draw());
			g.drawImage(ii2.getImage(), gameBomps.get(i).x, gameBomps.get(i).y, 40, 40, this);
		}
		for (int i = 0; i < gameBomps.size(); i++) {
			if (gameBomps.get(i).end())
				gameBomps.remove(i); // 炸完了
		}
		Demo.mainViewController.painting = false;
	}

}
