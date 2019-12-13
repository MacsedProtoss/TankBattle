package group.Macsed.TankBattle.Model.GameData.Barrier;

import group.Macsed.TankBattle.Model.GameData.GameBoxColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class BrickBarrier extends GameBoxColiderObject {
    private static float brickBarrierWidth=64,brickBarrierHeight=64;

    public BrickBarrier(float positionX,float positionY,float direction){
        this.positionX=positionX;
        this.positionY=positionY;
        this.direction=direction;
        this.coliderWidth=brickBarrierWidth;
        this.coliderHeight=brickBarrierHeight;
        ObjectType=GameObjectType.stonebarrier;
        whetherRigid=true;
        GameMap.theInstance.boxColiderObjectList.add(this);
    }
}
