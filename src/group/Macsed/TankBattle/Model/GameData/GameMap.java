package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Model.GameData.Bullet.GameBullet;
import group.Macsed.TankBattle.Model.GameData.Tank.GamePlayerTank;
import group.Macsed.TankBattle.Model.GameData.Tank.GameTank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameMap {



    public static GameMap theInstance;
    //private List<GameTank> tankList;
    //private List<GameBarrier> barrierList;
    //private List<GameBullet> bulletList;

    //public List<GameCircleColiderObject> circleColiderObjectList=new LinkedList<GameCircleColiderObject>();

    public int EnemyNum=3;

    public List<GameBoxColiderObject> boxColiderObjectList=new LinkedList<GameBoxColiderObject>();  //first
    public List<GameNoColiderObject> noColiderList=new LinkedList<GameNoColiderObject>();  //third
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


    public GameObjectType CheckBoxObjectCollision(GameBoxColiderObject theCheckedObject){
        //GameObject theObject=theCheckedObject;

        GameObjectType theCollisonObjType;


        for (GameBoxColiderObject forColiderObject : boxColiderObjectList) {
            if(forColiderObject!=theCheckedObject){//排除对自身的检测
                if(CheckTwoBoxColider(theCheckedObject,forColiderObject)){
                    theCollisonObjType=forColiderObject.getType();
                    if(theCollisonObjType==GameObjectType.enemyBullet||theCollisonObjType==GameObjectType.playerBullet){
//                        boxColiderObjectList.remove(forColiderObject);
                    }
                    return theCollisonObjType;
                }

            }
        }

        GameBoxColiderObject theboxplayer=(GameBoxColiderObject)thePlayer;

        if(theCheckedObject!=theboxplayer){
            if(CheckTwoBoxColider(theCheckedObject,theboxplayer)){
                return theboxplayer.getType();
            }
        }
        

        
        return GameObjectType.NULL;
    }

}
