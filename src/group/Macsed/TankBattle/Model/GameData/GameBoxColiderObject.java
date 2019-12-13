package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Model.GameData.Colider.GameColiderType;

public class GameBoxColiderObject extends GameColiderObject {
    public static float moveRangeX= GraphicCommonValues.shared.ScreenWidth()-GraphicCommonValues.shared.CommonObjSize()/2f;
    public static float moveRangeY=GraphicCommonValues.shared.ScreenHeight()-GraphicCommonValues.shared.CommonObjSize()/2f;

    public float coliderWidth,coliderHeight;//默认gameobject中的position为碰撞盒矩形中央
    public GameBoxColiderObject(){
        coliderType= GameColiderType.boxColider;
    }
}
