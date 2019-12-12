package group.Macsed.TankBattle.Foundation.Keyboard;

import group.Macsed.TankBattle.Model.GameData.GameDataManager;

public class KeyBoardEventManager {
    private KeyboardActiveKeys key ;
    private KeyboardActions action;
    private GameDataManager dataManager;

    public void setKey(KeyboardActiveKeys key) {
        this.key = key;
    }

    public void setAction(KeyboardActions action) {
        this.action = action;
    }

    public void setDataManager(GameDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void handleKeyEvent(){
        switch (key){
            case w:
                //up
                break;
            case a:
                // left
                break;
            case d:
                //right
                break;
            case s:
                //down
                break;
            case space:
                //fire
                break;
        }


    }

}
