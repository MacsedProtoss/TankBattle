package group.Macsed.TankBattle.Model.GameData.Tank;

import group.Macsed.TankBattle.Model.GameData.Colider.CollisionMessage;
import group.Macsed.TankBattle.Model.GameData.GameBoxColiderObject;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

import java.util.Random;

public class GameEnemyTank extends GameTank{

    protected float shootTimer=0f;
    protected float shootPerT=5;

    protected float directionChangeTimer=0f;

    protected float directionChangePerT=0.5f;


    public GameEnemyTank(float posX,float posY,float direction,float movespeed,float hp,float tdamaged){
        positionX=posX;
        positionY=posY;
        this.direction=direction;
        this.direction=90f*((int)(Math.random()*4));
        ObjectType= GameObjectType.enemytank;

        this.moveSpeed=movespeed;
        hP=hp;
        damage=tdamaged;
        GameMap.theInstance.boxColiderObjectList.add(this);
    }

    @Override
    public void Update() {
        if(shootTimer<0f){

            ShootBullet();
            shootTimer=shootPerT;
        }



        if(shootTimer>=0f){
            shootTimer-=0.1f;
        }

        if(directionChangeTimer<0f){
            direction=90f*((int)(Math.random()*4));
            directionChangeTimer=directionChangePerT;
        }
        if(directionChangeTimer>=0f){
            directionChangeTimer-=0.1f;
        }

        TankMove(direction);

        CollisionMessage collisionConsquence=GameMap.theInstance.CheckBoxObjectCollision((GameBoxColiderObject)this);
        if(collisionConsquence.whetherDamage){
            hP-=damage;
            if(hP<=0){
                //GameMap.theInstance.boxColiderObjectList.remove(this);
                GameMap.theInstance.toBeDeleteObjectSet.add(this);
                GameMap.theInstance.EnemyNum--;
            }
        }

    }
}
