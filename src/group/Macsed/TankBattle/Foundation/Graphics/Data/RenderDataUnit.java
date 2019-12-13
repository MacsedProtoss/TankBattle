package group.Macsed.TankBattle.Foundation.Graphics.Data;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class RenderDataUnit {

    public float Xposition;
    public float Yposition;

    public float width;
    public float height;

    private float actualW;
    private float actualH;

    public String path;

    public float[] anchors;

    public RenderDataUnit(String path,float xposition,float yposition,float width,float height){

        this.actualW = width;
        this.actualH = height;

        this.height = actualH / GraphicCommonValues.shared.ScreenHeight();
        this.width = actualW / GraphicCommonValues.shared.ScreenWidth();

        this.Xposition = xposition;
        this.Yposition = yposition;
        this.path = path;


        this.anchors = new float[8];
        anchors[0] = 1f;
        anchors[1] = 1f;
        anchors[2] = 1f;
        anchors[3] = 0f;
        anchors[4] = 0f;
        anchors[5] = 0f;
        anchors[6] = 0f;
        anchors[7] = 1f;
    }

    public void move(RenderDataMoveDirection direction){
        switch (direction){
            case up:
                Yposition += GraphicCommonValues.shared.moveSpeed();
                height = actualH / GraphicCommonValues.shared.ScreenHeight();
                width = actualW / GraphicCommonValues.shared.ScreenWidth();
                anchors[0] = 1f;
                anchors[1] = 1f;
                anchors[2] = 1f;
                anchors[3] = 0f;
                anchors[4] = 0f;
                anchors[5] = 0f;
                anchors[6] = 0f;
                anchors[7] = 1f;
                break;
            case down:
                Yposition -= GraphicCommonValues.shared.moveSpeed();
                height = actualH / GraphicCommonValues.shared.ScreenHeight();
                width = actualW / GraphicCommonValues.shared.ScreenWidth();
                anchors[0] = 1f;
                anchors[1] = 0f;
                anchors[2] = 1f;
                anchors[3] = 1f;
                anchors[4] = 0f;
                anchors[5] = 1f;
                anchors[6] = 0f;
                anchors[7] = 0f;
                break;
            case left:
                Xposition -= GraphicCommonValues.shared.moveSpeed();
                height = actualW / GraphicCommonValues.shared.ScreenHeight();
                width = actualH / GraphicCommonValues.shared.ScreenWidth();
                anchors[0] = 1f;
                anchors[1] = 0f;
                anchors[2] = 0f;
                anchors[3] = 0f;
                anchors[4] = 0f;
                anchors[5] = 1f;
                anchors[6] = 1f;
                anchors[7] = 1f;
                break;
            case right:
                Xposition += GraphicCommonValues.shared.moveSpeed();
                height = actualW / GraphicCommonValues.shared.ScreenHeight();
                width = actualH / GraphicCommonValues.shared.ScreenWidth();
                anchors[0] = 0f;
                anchors[1] = 1f;
                anchors[2] = 1f;
                anchors[3] = 1f;
                anchors[4] = 1f;
                anchors[5] = 0f;
                anchors[6] = 0f;
                anchors[7] = 0f;
                break;
        }

        System.out.println(actualH);
        System.out.println(GraphicCommonValues.shared.ScreenHeight());
        System.out.println(GraphicCommonValues.shared.ScreenWidth());
        System.out.println(height);
        System.out.println(width);

    }



}
