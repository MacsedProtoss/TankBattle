package group.Macsed.TankBattle.Model.GameData.Barrier;

import group.Macsed.TankBattle.Model.GameData.GameBoxColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class StoneBarrier extends GameBoxColiderObject {
    private static float stoneBarrierWidth=64,stoneBarrierHeight=64;

    public StoneBarrier(float positionX,float positionY,float direction){
        this.positionX=positionX;
        this.positionY=positionY;
        this.direction=direction;
        this.coliderWidth=stoneBarrierWidth;
        this.coliderHeight=stoneBarrierHeight;
        ObjectType=GameObjectType.stonebarrier;
        whetherRigid=true;
        GameMap.theInstance.boxColiderObjectList.add(this);
    }
}
