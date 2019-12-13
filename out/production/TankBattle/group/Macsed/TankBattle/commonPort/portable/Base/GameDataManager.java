package group.macsed.commonPort.portable.Base;

import group.macsed.commonPort.portable.Base.Tank.GameTank;
import group.macsed.commonPort.portable.Base.Tank.EnemyTank;
import group.macsed.commonPort.portable.Utils.CoreTool;

import java.util.ArrayList;

public class GameDataManager {

	public ArrayList<GameTank> list = new ArrayList<GameTank>(); // 坦克集合
	public ArrayList<GameBullet> list2 = new ArrayList<>();
	public ArrayList<EnemyTank> list3 = new ArrayList<EnemyTank>();
	public ArrayList<GameBullet> gameBullet = new ArrayList<>();
	public ArrayList<GameBomp> gameBomps = new ArrayList<>();

	public int[][] map = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 }, { 0, 0, 0, 2, 3, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
			{ 5, 0, 0, 5, 5, 5, 0, 0, 5, 5, 0, 0, 5, 5, 5 }, { 0, 1, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2 },
			{ 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 3, 4, 3, 0, 0, 0, 0, 0, 0, 0 } };;

	public GameDataManager() {
		init();
	}

	public GameDataManager(ArrayList<GameTank> list) {
		this.list = list;
	}

	public void init() { // 初始化自己的坦克
		GameTank t = new GameTank(50, 300, 40, 40, 2, 0, 8);
		list.add(t);
	}

	private int getTy() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getTx() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int getDir() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void initEnemy() { // 初始化敌人坦克类
		// Random r = new Random();
		// for (int i = 0; i < 3; i++) {
		// int etx = r.nextInt(500) + 10;
		// int ety = r.nextInt(500) + 10;
		// int hp = 100;
		// int dir = r.nextInt(4); // TODO
		// int edictance = 1;
		// EnemyTank et = new EnemyTank(etx, ety, hp, dir, edictance, 1, 1);
		// list3.add(et);
		// }
		CoreTool.make_tank(1);
		CoreTool.make_tank(2);
		CoreTool.make_tank(3);
	}

	public ArrayList<GameTank> getList() {
		return list;
	}

	public void setList(ArrayList<GameTank> list) {
		this.list = list;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public ArrayList<GameBullet> getList2() {
		return list2;
	}

	public void setList2(ArrayList<GameBullet> list2) {
		this.list2 = list2;
	}

	public ArrayList<EnemyTank> getList3() {
		return list3;
	}

	public void setList3(ArrayList<EnemyTank> list3) {
		this.list3 = list3;
	}

	public ArrayList<GameBullet> getGameBullet() {
		return gameBullet;
	}

	public void setGameBullet(ArrayList<GameBullet> gameBullet) {
		this.gameBullet = gameBullet;
	}

}
