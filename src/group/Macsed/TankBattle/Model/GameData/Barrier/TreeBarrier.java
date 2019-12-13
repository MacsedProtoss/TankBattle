package group.Macsed.TankBattle.Model.GameData.Barrier;

import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameNoColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameObject;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class TreeBarrier extends GameNoColiderObject {

    public TreeBarrier(){
        ObjectType=GameObjectType.treebarrier;
    }
    public TreeBarrier(float positionX,float positionY,float direction){
        this.positionX=positionX;
        this.positionY=positionY;
        this.direction=direction;
        ObjectType=GameObjectType.treebarrier;
        GameMap.theInstance.noColiderList.add(this);
    }
}
