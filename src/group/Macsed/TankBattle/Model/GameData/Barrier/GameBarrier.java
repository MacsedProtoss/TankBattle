package group.Macsed.TankBattle.Model.GameData.Barrier;

import group.Macsed.TankBattle.Model.GameData.GameObject;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class GameBarrier extends GameObject {

    private GameBarrierType barrierType;

    public GameBarrierType getBarrierType() {
        return barrierType;
    }

    public void setBarrierType(GameBarrierType barrierType) {
        this.barrierType = barrierType;
    }

    public GameBarrier(){
        super();
        setType(GameObjectType.barrier);
    }
}
