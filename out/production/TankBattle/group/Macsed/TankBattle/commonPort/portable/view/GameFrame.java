package group.macsed.commonPort.portable.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import group.macsed.commonPort.portable.main.Demo;

public class GameFrame extends JFrame {

	private GamePanel panel = new GamePanel();
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("Game");
	private JMenuItem menuitem_start = new JMenuItem("Start");
	private JMenuItem menuitem_restart = new JMenuItem("Restart");
	private JMenuItem menuitem_rank = new JMenuItem("Rank");
	private JMenuItem menuitem_custom = new JMenuItem("Custom");
	private JMenuItem menuitem_exit = new JMenuItem("Exit");

	private JMenu menu_jump = new JMenu("Jump to");
	private JMenuItem menuitem_level1 = new JMenuItem("Level 1");
	private JMenuItem menuitem_level2 = new JMenuItem("Level 2");
	private JMenuItem menuitem_level3 = new JMenuItem("Level 3");

	public GameFrame() {
		menuitem_start.setActionCommand("start");
		menu.add(menuitem_start);
		menu.addSeparator();
		menu.add(menuitem_restart);
		menu.addSeparator();
		menu.add(menuitem_rank);
		menu.addSeparator();
		menu.add(menuitem_custom);
		menu.addSeparator();
		menuitem_start.setActionCommand("Exit");
		menu.add(menuitem_exit);
		menu_jump.add(menuitem_level1);
		menu.addSeparator();
		menu_jump.add(menuitem_level2);
		menu.addSeparator();
		menu_jump.add(menuitem_level3);
		menuitem_exit.addActionListener(Demo.ha);
		menuitem_level1.setActionCommand("jump1");
		menuitem_level2.setActionCommand("jump2");
		menuitem_level3.setActionCommand("jump3");
		menuitem_level1.addActionListener(Demo.ha);
		menuitem_level2.addActionListener(Demo.ha);
		menuitem_level3.addActionListener(Demo.ha);
		bar.add(menu);
		bar.add(menu_jump);
		this.setJMenuBar(bar);

		this.setResizable(false);
		this.add(panel);
		this.setTitle("TankBattle");
		this.pack();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(false);
	}

	public GamePanel getPanel() {
		return panel;
	}

	public void setHop(GamePanel hop2) {
		this.panel = hop2;
	}

}
