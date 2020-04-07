package group.Macsed.TankBattle.Scene;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    private JPanel bgp;
    private JButton newGame;
    private JButton rank;
    private JButton gameExit;
    private JLayeredPane lp;
    private ImageIcon button;

    public Home(){
        super("TankBattle");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new ImageIcon("src\\group\\Macsed\\TankBattle\\Scene\\Button.jpg");
        button.setImage(button.getImage().getScaledInstance(200, 50,Image.SCALE_DEFAULT ));
        lp = new JLayeredPane();
        bgp = new BackgroundPanel((new ImageIcon("src\\group\\Macsed\\TankBattle\\Scene\\BGP.jpg")).getImage());
        bgp.setBounds(0,0,500,500);
        lp.add(bgp,JLayeredPane.DEFAULT_LAYER);
        newGame =new JButton("开始游戏",button);
        newGame.setBounds(150,100,200,50);
        newGame.addActionListener(actionEvent -> {});
        rank =new JButton("排行榜",button);
        rank.setBounds(150,200,200,50);
        rank.addActionListener(actionEvent -> {});
        gameExit =new JButton("退出游戏",button);
        gameExit.setBounds(150,300,200,50);
        gameExit.addActionListener(actionEvent -> System.exit(0));
        setButton(gameExit);
        setButton(newGame);
        setButton(rank);
        this.setLayeredPane(lp);
        this.setSize(516,538);
        this.setLocation(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    private void setButton(JButton button){
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setBorderPainted(false);
        lp.add(button,JLayeredPane.MODAL_LAYER);
    }
}
