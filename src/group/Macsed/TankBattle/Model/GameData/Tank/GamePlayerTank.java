package group.Macsed.TankBattle.Model.GameData.Tank;

import group.Macsed.TankBattle.Foundation.Keyboard.KeyboardActiveKeys;
import group.Macsed.TankBattle.Model.GameData.GameBoxColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class GamePlayerTank extends GameTank{

    protected float shootTimer=0f;
    protected float shootPerT=5;

    public GamePlayerTank(float posX,float posY,float direction,float movespeed,float hp,float tdamaged){
        positionX=posX;
        positionY=posY;
        this.direction=direction;
        ObjectType= GameObjectType.player;

        this.moveSpeed=movespeed;
        hP=hp;
        damage=tdamaged;

        GameMap.theInstance.thePlayer=this;

    }




    public int Update(KeyboardActiveKeys theKey){

        if(theKey==KeyboardActiveKeys.w){

            TankMove(90);
        }
        else if(theKey==KeyboardActiveKeys.a){

            TankMove(180);
        }
        else if(theKey==KeyboardActiveKeys.s){

            TankMove(270);
        }
        else if(theKey==KeyboardActiveKeys.d){

            TankMove(0);
        }
        else if(theKey==KeyboardActiveKeys.space){
            if(shootTimer<0f){

                ShootBullet();
                shootTimer=shootPerT;
            }
        }


        if(shootTimer>=0f){
            shootTimer-=0.1f;
        }



        GameObjectType collisionConsquence=GameMap.theInstance.CheckBoxObjectCollision((GameBoxColiderObject)this);
        if(collisionConsquence==GameObjectType.enemyBullet){
            hP-=damage;
            if(hP<=0){
                return -1;
            }
        }






        return 0;
    }
}
