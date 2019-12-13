package group.macsed.commonPort.portable.Base;

public class GameBomp {
	public int num = 1; // 爆炸的第几阶段
	public int x;
	public int y;

	public boolean end() {
		return (num == 60);
	}

	public GameBomp(int x, int y) {
		this.x = x;// 爆炸地点
		this.y = y;
	}

	public String draw() {
		String path = "img/bomp/爆炸" + Integer.toString(((num - 1) / 8) + 1) + ".png";
		num++;
		return path;
	}
}
