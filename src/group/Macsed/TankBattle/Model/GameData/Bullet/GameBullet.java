package group.Macsed.TankBattle.Model.GameData.Bullet;

import group.Macsed.TankBattle.Model.GameData.GameObject;
import group.Macsed.TankBattle.Model.GameData.GameObjectType;

public class GameBullet extends GameObject {

    private GameBulletType bulletType;

    public GameBulletType getBulletType() {
        return bulletType;
    }

    public void setBulletType(GameBulletType bulletType) {
        this.bulletType = bulletType;
    }

    public GameBullet(){
        super();
        setType(GameObjectType.bullet);
    }

}
