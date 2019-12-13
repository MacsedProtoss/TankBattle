package group.Macsed.TankBattle.Model.GameData;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyboardActiveKeys;
import group.Macsed.TankBattle.Model.GameData.Barrier.BrickBarrier;
import group.Macsed.TankBattle.Model.GameData.Barrier.StoneBarrier;
import group.Macsed.TankBattle.Model.GameData.Barrier.TreeBarrier;
import group.Macsed.TankBattle.Model.GameData.Tank.GameEnemyTank;
import group.Macsed.TankBattle.Model.GameData.Tank.GamePlayerTank;

//总 manager
public class GameDataManager {

//    public static GameDataManager shared = new GameDataManager();

    public void initGameSceneData(){
        new GameMap();

        for(int i=0;i<5;i++){
            new TreeBarrier((i-2)*GraphicCommonValues.shared.CommonObjSize(),100,0);
        }


        for(int i=0;i<5;i++){
            new BrickBarrier((i-2)*GraphicCommonValues.shared.CommonObjSize(),200,0);
        }


        for(int i=0;i<5;i++){
            new StoneBarrier((i-2)*GraphicCommonValues.shared.CommonObjSize(),300,0);
        }

        for(int i=0;i<3;i++){
            new GameEnemyTank((i-1)*GraphicCommonValues.shared.CommonObjSize()*5,-100,0,GraphicCommonValues.shared.moveSpeed()*GraphicCommonValues.shared.ScreenWidth(),GraphicCommonValues.shared.enermyHelath(),GraphicCommonValues.shared.enermyDamage());
        }


        new GamePlayerTank(0,0,0, GraphicCommonValues.shared.moveSpeed()*GraphicCommonValues.shared.ScreenWidth(),GraphicCommonValues.shared.playerHealth(),GraphicCommonValues.shared.playerDamage());




    }


    //返回1说明胜利，返回0说明正常，返回-1说明失败
    public int Update(KeyboardActiveKeys thekey){

        //突然发现NoColider没啥Update可调用的，，，，
        /*
        for (GameNoColiderObject theObject: GameMap.theInstance.noColiderList) {
            theObject.update();
        }
        */
        int updateConsequence=0;
        for (GameBoxColiderObject theObject: GameMap.theInstance.boxColiderObjectList) {
            theObject.Update();
        }

        if(GameMap.theInstance.EnemyNum<=0)updateConsequence=1;

        updateConsequence=GameMap.theInstance.thePlayer.Update(thekey);

        return updateConsequence;
    }

    public void ClearData(){
        GameMap.theInstance=null;
    }


}
