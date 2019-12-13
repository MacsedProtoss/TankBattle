package group.Macsed.TankBattle.Model.GameData;

import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GameObject {

    protected float positionX=0;
    protected float positionY=0;
    protected float direction=0;//角度制  0~360   0 右,90 上,180 左,270 下
    protected GameObjectType ObjectType;



    //protected float pictureWidth=0;
    //protected float pictureHeight=0;
    protected GameObject(){

        positionX = 0;
        positionY = 0;
        direction=0;
        /*
        pictureWidth = 0;
        pictureHeight = 0;
        */

    }


    public void setPositionX(float positionX) { this.positionX = positionX; }
    public void setPositionY(float positionY) { this.positionY = positionY; }
    public void setDirection(float direction){ this.direction=direction; }

    //public void setPictureWidth(float width) { this.pictureWidth = width; }
    //public void setPictureHeight(float height) { this.pictureHeight = height; }

    public void setType(GameObjectType type) { this.ObjectType = type; }


    public float getPositionX(){return  positionX;}
    public float getPositionY(){return  positionY;}
    public float getDirection(){return  direction;}

    //public float getPictureWidth(){return pictureWidth;}
    //public float getPictureHeight(){return pictureHeight;}

    public GameObjectType getType() {
        return ObjectType;
    }



    //相当于默认方法，什么都不做
    public void Update(){
    }
}
