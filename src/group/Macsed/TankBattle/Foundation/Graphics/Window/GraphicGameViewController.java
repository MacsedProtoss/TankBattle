package group.Macsed.TankBattle.Foundation.Graphics.Window;

import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitManager;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitType;
import group.Macsed.TankBattle.Foundation.Graphics.Window.base.GraphicWindowController;

public class GraphicGameViewController extends GraphicWindowController {

    public void initGameObj(){
        RenderUnitManager.shared.clearList();
        RenderUnitManager.shared.addUnitToList("player","/Volumes/DATA/1.png",1280f,720f,0f,0f, RenderUnitType.tank);
    }

    @Override
    public void run() {
        initGameObj();
        super.run();
    }

    @Override
    protected void updateAndDraw() {

        //TODO

        super.updateAndDraw();
    }
}
