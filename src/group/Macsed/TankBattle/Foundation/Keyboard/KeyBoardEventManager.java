package group.Macsed.TankBattle.Foundation.Keyboard;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataMoveDirection;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitManager;
;


public class KeyBoardEventManager {

    public static KeyBoardEventManager shared = new KeyBoardEventManager();

    public void handleKeyEvent(KeyboardActiveKeys key){
        switch (key){
            case w:
                RenderUnitManager.shared.getPlayer().getData().move(RenderDataMoveDirection.up);
                break;
            case a:
                // left
                RenderUnitManager.shared.getPlayer().getData().move(RenderDataMoveDirection.left);
                break;
            case d:
                //right
                RenderUnitManager.shared.getPlayer().getData().move(RenderDataMoveDirection.right);
                break;
            case s:
                //down
                RenderUnitManager.shared.getPlayer().getData().move(RenderDataMoveDirection.down);
                break;
            case space:
                //fire
                break;
        }


    }

}
