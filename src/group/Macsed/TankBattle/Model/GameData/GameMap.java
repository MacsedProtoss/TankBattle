package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Model.GameData.Bullet.GameBullet;
import group.Macsed.TankBattle.Model.GameData.Colider.CollisionMessage;
import group.Macsed.TankBattle.Model.GameData.Tank.GamePlayerTank;
import group.Macsed.TankBattle.Model.GameData.Tank.GameTank;

import java.util.*;

public class GameMap {



    public static GameMap theInstance;
    //private List<GameTank> tankList;
    //private List<GameBarrier> barrierList;
    //private List<GameBullet> bulletList;

    //public List<GameCircleColiderObject> circleColiderObjectList=new LinkedList<GameCircleColiderObject>();

    public int EnemyNum=3;

    public List<GameBoxColiderObject> boxColiderObjectList=new LinkedList<GameBoxColiderObject>();  //first
    public List<GameNoColiderObject> noColiderList=new LinkedList<GameNoColiderObject>();  //third


    public Set<GameBoxColiderObject> toBeDeleteObjectSet=new HashSet<GameBoxColiderObject>();


    public GamePlayerTank thePlayer; //second


    public GameMap(){
        //thePlayer=theplayer;
        theInstance=this;
    }



    //打算全都采用矩形碰撞盒检测算了，，，，不然太蛋疼了，可能会写不完。。。
    //矩形碰撞盒检测
    private static boolean CheckTwoBoxColider(GameBoxColiderObject colider1,GameBoxColiderObject colider2){
        return (Math.abs(colider1.positionX-colider2.positionX)<(colider1.coliderWidth+colider2.coliderWidth)/2)&&
                (Math.abs(colider1.positionY-colider2.positionY)<(colider1.coliderHeight+colider2.coliderHeight)/2);
    }


    public CollisionMessage CheckBoxObjectCollision(GameBoxColiderObject theCheckedObject){
        //GameObject theObject=theCheckedObject;

        CollisionMessage theCollisonConsquence=new CollisionMessage();


        for (GameBoxColiderObject forColiderObject : boxColiderObjectList) {
            if(forColiderObject!=theCheckedObject){//排除对自身的检测
                if(CheckTwoBoxColider(theCheckedObject,forColiderObject)){
                    if(theCheckedObject.ObjectType==GameObjectType.stonebarrier){
                        if(forColiderObject.ObjectType==GameObjectType.enemyBullet||forColiderObject.ObjectType==GameObjectType.playerBullet){
                            toBeDeleteObjectSet.add(forColiderObject);
                        }
                    }
                    else if(theCheckedObject.ObjectType==GameObjectType.brickbarrier){
                        if(forColiderObject.ObjectType==GameObjectType.enemyBullet||forColiderObject.ObjectType==GameObjectType.playerBullet){
                            toBeDeleteObjectSet.add(forColiderObject);
                            toBeDeleteObjectSet.add(theCheckedObject);
                        }
                    }
                    else if(theCheckedObject.ObjectType==GameObjectType.enemytank){
                        if(forColiderObject.ObjectType==GameObjectType.enemyBullet||forColiderObject.ObjectType==GameObjectType.playerBullet){
                            toBeDeleteObjectSet.add(forColiderObject);
                            if(forColiderObject.ObjectType==GameObjectType.playerBullet){

                                theCollisonConsquence.whetherDamage=true;
                            }
                        }
                        else{
                            theCollisonConsquence.whetherMove=false;
                        }
                    }
                    else if(theCheckedObject.ObjectType==GameObjectType.player){
                        if(forColiderObject.ObjectType==GameObjectType.enemyBullet||forColiderObject.ObjectType==GameObjectType.playerBullet){
                            toBeDeleteObjectSet.add(forColiderObject);
                            if(forColiderObject.ObjectType==GameObjectType.enemyBullet){

                                theCollisonConsquence.whetherDamage=true;
                            }
                        }
                        else{
                            theCollisonConsquence.whetherMove=false;
                        }
                    }




                }

            }
        }

        GameBoxColiderObject theboxplayer=(GameBoxColiderObject)thePlayer;

        if(theCheckedObject!=theboxplayer){
            if(CheckTwoBoxColider(theCheckedObject,theboxplayer)){
                theCollisonConsquence.whetherMove=false;
            }
        }



        return theCollisonConsquence;
    }

}
