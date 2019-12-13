package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Model.GameData.Colider.GameColiderType;

public class GameCircleColiderObject extends GameColiderObject {
    public float radius=0;
    public GameCircleColiderObject(){
        coliderType= GameColiderType.circleColider;
    }
}
