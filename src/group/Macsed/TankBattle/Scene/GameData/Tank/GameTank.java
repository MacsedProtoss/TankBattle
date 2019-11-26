package group.Macsed.TankBattle.Scene.GameData.Tank;

import group.Macsed.TankBattle.Scene.GameData.GameObject;
import group.Macsed.TankBattle.Scene.GameData.GameObjectType;

public class GameTank extends GameObject {

    private GameTankType tankType;

    public GameTankType getTankType() {
        return tankType;
    }

    public void setTankType(GameTankType tankType) {
        this.tankType = tankType;
    }

    public GameTank(){
        super();
        setType(GameObjectType.tank);
    }






}
