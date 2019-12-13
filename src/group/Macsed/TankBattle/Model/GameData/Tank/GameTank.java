package group.Macsed.TankBattle.Model.GameData.Tank;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Model.GameData.*;
import group.Macsed.TankBattle.Model.GameData.Bullet.GameBullet;
import group.Macsed.TankBattle.Model.GameData.Colider.CollisionMessage;

public class GameTank extends GameBoxColiderObject {
    protected float moveSpeed=0f;
    protected float hP=0;
    protected final float shootBulletDDistance=100;
    protected float damage=0;



    private static float tankWidth=64*2,tankHeight=64*2;
    public GameTank(){
        coliderWidth=tankWidth;
        coliderHeight=tankHeight;
        whetherRigid=true;

    }



    protected void TankMove(float direction){
        this.direction=direction;
        //float newPosX,newPosY;
        float oldPosX,oldPosY;
        oldPosX=positionX;
        oldPosY=positionY;

        if(direction==0f){
            positionX+=moveSpeed;
        }
        else if(direction== 90f){
            positionY+=moveSpeed;
        }
        else if(direction==180f){
            positionX-=moveSpeed;

        }
        else if(direction==270f){
            positionY-=moveSpeed;
        }



        if(Math.abs(positionX)+coliderWidth/2>= GraphicCommonValues.shared.ScreenWidth() ||Math.abs(positionY)+coliderHeight/2>GraphicCommonValues.shared.ScreenHeight()){
            positionX=oldPosX;
            positionY=oldPosY;
            return;
        }


        //positionX=newPosX;
        //positionY=newPosY;

/*
        GameObjectType collisionConsquence=GameMap.theInstance.CheckBoxObjectCollision((GameBoxColiderObject)this);
        if((collisionConsquence!=GameObjectType.player)&&(collisionConsquence!=GameObjectType.enemytank)
                &&(collisionConsquence!=GameObjectType.brickbarrier)&&(collisionConsquence!=GameObjectType.stonebarrier)){
            positionX=newPosX;
            positionY=newPosY;
            return ;
        }
*/
        CollisionMessage collisionConsquence=GameMap.theInstance.CheckBoxObjectCollision((GameBoxColiderObject)this);
        if(!collisionConsquence.whetherMove){
            positionX=oldPosX;
            positionY=oldPosY;
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




        new GameBullet(newPosX,newPosY,direction,
                        (ObjectType==GameObjectType.player)?GameObjectType.playerBullet:GameObjectType.enemyBullet);




    }

}
