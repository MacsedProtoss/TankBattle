package group.Macsed.TankBattle.Model.GameData.Tank;

import group.Macsed.TankBattle.Model.GameData.*;
import group.Macsed.TankBattle.Model.GameData.Bullet.GameBullet;

public class GameTank extends GameBoxColiderObject {
    protected float moveSpeed=0f;
    protected float hP=0;
    protected final float shootBulletDDistance=40;
    protected float damage=0;



    private static float tankWidth=64,tankHeight=64;
    public GameTank(){
        coliderWidth=tankWidth;
        coliderHeight=tankHeight;
        whetherRigid=true;

    }


    protected void TankMove(float direction){
        float newPosX,newPosY;
        newPosX=positionX;
        newPosY=positionY;
        if(direction==0f){
            newPosX+=moveSpeed;
        }
        else if(direction== 90f){
            newPosY+=moveSpeed;
        }
        else if(direction==180f){
            newPosX-=moveSpeed;

        }
        else if(direction==270f){
            newPosY-=moveSpeed;
        }



        if(Math.abs(positionX)>moveRangeX||Math.abs(positionY)>moveRangeY){
            return;
        }


        GameObjectType collisionConsquence=GameMap.theInstance.CheckBoxObjectCollision((GameBoxColiderObject)this);
        if((collisionConsquence!=GameObjectType.player)&&(collisionConsquence!=GameObjectType.enemytank)
                &&(collisionConsquence!=GameObjectType.brickbarrier)&&(collisionConsquence!=GameObjectType.stonebarrier)){
            positionX=newPosX;
            positionY=newPosY;
            return ;
        }

    }

    protected void ShootBullet(){

        float newPosX,newPosY;
        newPosX=positionX;
        newPosY=positionY;
        if(direction==0f){
            newPosX+=shootBulletDDistance;
        }
        else if(direction== 90f){
            newPosY+=shootBulletDDistance;
        }
        else if(direction==180f){
            newPosX-=shootBulletDDistance;

        }
        else if(direction==270f){
            newPosY-=shootBulletDDistance;
        }



        GameMap.theInstance.boxColiderObjectList.add(
                new GameBullet(newPosX,newPosY,direction,
                        (ObjectType==GameObjectType.player)?GameObjectType.playerBullet:GameObjectType.enemyBullet));




    }

}
