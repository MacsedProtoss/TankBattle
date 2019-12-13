package group.Macsed.TankBattle.Model.GameData.Bullet;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Model.GameData.GameBoxColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObject;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class GameBullet extends GameBoxColiderObject {
    //private float damage=5;
    private static float bulletWidth=4,bulletHeight=4;
    private static float bulletSpeed=1.2f/ GraphicCommonValues.shared.ScreenWidth();


    public GameBullet(float positonX,float positionY,float direction,GameObjectType bulletType){
        this.positionX=positonX;
        this.positionY=positionY;
        this.direction=direction;
        this.ObjectType=bulletType;

        whetherRigid=false;

        //this.damage=damage;

        this.coliderWidth=bulletWidth;
        this.coliderHeight=bulletHeight;
        whetherRigid=false;

//        GameMap.theInstance.boxColiderObjectList.add(this);

    }




    @Override
    public void Update(){
        float newPosX,newPosY;
        newPosX=positionX;
        newPosY=positionY;
        if(direction==0f){
            newPosX+=bulletSpeed;
        }
        else if(direction== 90f){
            newPosY+=bulletSpeed;
        }
        else if(direction==180f){
            newPosX-=bulletSpeed;

        }
        else if(direction==270f){
            newPosY-=bulletSpeed;
        }

        positionX=newPosX;
        positionY=newPosY;

        if(Math.abs(positionX)>moveRangeX||Math.abs(positionY)>moveRangeY){
            GameMap.theInstance.boxColiderObjectList.remove(this);
        }


    }


}
