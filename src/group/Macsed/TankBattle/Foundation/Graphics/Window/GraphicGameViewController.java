package group.Macsed.TankBattle.Foundation.Graphics.Window;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitManager;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitType;
import group.Macsed.TankBattle.Foundation.Graphics.Window.base.GraphicWindowController;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyBoardEventManager;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyboardActiveKeys;
import group.Macsed.TankBattle.Main;
import group.Macsed.TankBattle.Model.GameData.GameDataManager;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_D;

public class GraphicGameViewController extends GraphicWindowController {

    private GameDataManager manager;

    public void initGameObj(){
        RenderUnitManager.shared.clearList();
        RenderUnitManager.shared.addUnitToList("player",GraphicCommonValues.shared.classpath()+"resources/playerTank.jpg",64f,64f,0f,0f, RenderUnitType.tank);
        manager = new GameDataManager();
        manager.initGameSceneData();
    }

    @Override
    public void run() {
        initGameObj();
//        System.out.println();

        super.run();
    }

    @Override
    protected void updateAndDraw() {

        //TODO

        super.updateAndDraw();
    }

    @Override
    protected void setKeyCallBack() {
            glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
                if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) {
                    glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
                }
                if (key == GLFW_KEY_W){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.w);
                    manager.Update(KeyboardActiveKeys.w);
                }

                if (key == GLFW_KEY_A){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.a);
                    manager.Update(KeyboardActiveKeys.a);
                }

                if (key == GLFW_KEY_S){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.s);
                    manager.Update(KeyboardActiveKeys.s);
                }

                if (key == GLFW_KEY_D){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.d);
                    manager.Update(KeyboardActiveKeys.d);
                }

            });


    }
}
