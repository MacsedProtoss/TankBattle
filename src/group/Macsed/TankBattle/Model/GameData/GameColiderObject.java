package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Model.GameData.Colider.GameColiderType;

public class GameColiderObject extends GameObject{
    public boolean whetherRigid=false;//是否为刚体，为刚体则不可重叠；不是刚体的话，则可以重叠，但检测中会返回触发碰撞（不同情况返回的触发类型不同）
    public GameColiderType coliderType;
}
