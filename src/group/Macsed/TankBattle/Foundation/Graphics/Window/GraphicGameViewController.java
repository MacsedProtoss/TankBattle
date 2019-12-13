package group.Macsed.TankBattle.Foundation.Graphics.Window;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataMoveDirection;
import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitManager;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitType;
import group.Macsed.TankBattle.Foundation.Graphics.Window.base.GraphicWindowController;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyBoardEventManager;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyboardActiveKeys;
import group.Macsed.TankBattle.Main;
import group.Macsed.TankBattle.Model.GameData.GameDataManager;
import group.Macsed.TankBattle.Model.GameData.GameMap;
import group.Macsed.TankBattle.Model.GameData.GameObject;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class GraphicGameViewController extends GraphicWindowController {

    private GameDataManager manager;

    public void initGameObj(){
        RenderUnitManager.shared.clearList();
        manager = new GameDataManager();
        manager.initGameSceneData();
        refreshList();
    }

    private String getTexturePath(GameObjectType type){
        switch (type){
            case player:
                return GraphicCommonValues.shared.classpath()+"resources/playerTank.jpg";
            case enemyBullet:
                return GraphicCommonValues.shared.classpath()+"resources/bullet.jpg";
            case playerBullet:
                return GraphicCommonValues.shared.classpath()+"resources/bullet.jpg";
            case stonebarrier:
                return GraphicCommonValues.shared.classpath()+"resources/stone.jpg";
            case enemytank:
                return GraphicCommonValues.shared.classpath()+"resources/enemyTank.jpg";
            case treebarrier:
                return GraphicCommonValues.shared.classpath()+"resources/tree.jpg";
            case brickbarrier:
                return GraphicCommonValues.shared.classpath()+"resources/brick.jpg";
            default:
                return "";
        }
    }

    private RenderUnitType getTextureType(GameObjectType type){
        switch (type){
            case player:
                return RenderUnitType.tank;
            case enemyBullet:
                return RenderUnitType.bullet;
            case playerBullet:
                return RenderUnitType.bullet;
            case stonebarrier:
                return RenderUnitType.barrier;
            case enemytank:
                return RenderUnitType.tank;
            case treebarrier:
                return RenderUnitType.barrier;
            case brickbarrier:
                return RenderUnitType.barrier;
            default:
                return null;
        }
    }

    private RenderDataMoveDirection getDirection(float direction){
        if (direction == 0f){
            return RenderDataMoveDirection.right;
        }else if(direction == 90f){
            return RenderDataMoveDirection.up;
        }else if (direction == 180f){
            return  RenderDataMoveDirection.left;
        }else{
            return RenderDataMoveDirection.down;
        }
    }

    private void refreshList(){

        for (GameObject obj: GameMap.theInstance.boxColiderObjectList
        ) {

            RenderUnitManager.shared.addUnitToList("normal",getTexturePath(obj.getType()),GraphicCommonValues.shared.CommonObjSize(),GraphicCommonValues.shared.CommonObjSize(),obj.getPositionX()/GraphicCommonValues.shared.ScreenWidth(),obj.getPositionY()/GraphicCommonValues.shared.ScreenHeight(),getTextureType(obj.getType()));
            RenderUnitManager.shared.units.get(RenderUnitManager.shared.units.size() - 1).getData().changeDirection(getDirection(obj.getDirection()));
        }

        RenderUnitManager.shared.addUnitToList("player",getTexturePath(GameMap.theInstance.thePlayer.getType()),GraphicCommonValues.shared.CommonObjSize(),GraphicCommonValues.shared.CommonObjSize(),GameMap.theInstance.thePlayer.getPositionX()/GraphicCommonValues.shared.ScreenWidth(),GameMap.theInstance.thePlayer.getPositionY()/GraphicCommonValues.shared.ScreenHeight(),getTextureType(GameMap.theInstance.thePlayer.getType()));
        RenderUnitManager.shared.units.get(RenderUnitManager.shared.units.size() - 1).getData().changeDirection(getDirection(GameMap.theInstance.thePlayer.getDirection()));


        for (GameObject obj: GameMap.theInstance.noColiderList
        ) {

            RenderUnitManager.shared.addUnitToList("mix",getTexturePath(obj.getType()),GraphicCommonValues.shared.CommonObjSize(),GraphicCommonValues.shared.CommonObjSize(),obj.getPositionX()/GraphicCommonValues.shared.ScreenWidth(),obj.getPositionY()/GraphicCommonValues.shared.ScreenHeight(),getTextureType(obj.getType()));
            RenderUnitManager.shared.units.get(RenderUnitManager.shared.units.size() - 1).getData().changeDirection(getDirection(obj.getDirection()));
        }

    }

    @Override
    public void run() {
        initGameObj();
//        System.out.println();

        super.run();
    }

    @Override
    protected void updateAndDraw() {


        manager.Update(null);

        RenderUnitManager.shared.clearList();
        refreshList();

        super.updateAndDraw();
    }

    @Override
    protected void setKeyCallBack() {
            glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) {
                    glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
                } else if (key == GLFW_KEY_W){
//                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.w);
                    manager.Update(KeyboardActiveKeys.w);
                }else if (key == GLFW_KEY_A){
//                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.a);
                    manager.Update(KeyboardActiveKeys.a);
                }else if (key == GLFW_KEY_S){
//                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.s);
                    manager.Update(KeyboardActiveKeys.s);
                }else if (key == GLFW_KEY_D){
//                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.d);
                    manager.Update(KeyboardActiveKeys.d);
                }else if (key == GLFW_KEY_SPACE){
                    manager.Update(KeyboardActiveKeys.space);
                }else{

                }

            });


    }
}
