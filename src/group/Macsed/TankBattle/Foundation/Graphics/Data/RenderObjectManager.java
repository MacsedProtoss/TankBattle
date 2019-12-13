package group.Macsed.TankBattle.Foundation.Graphics.Data;

import java.util.LinkedList;
import java.util.List;

public class RenderObjectManager {

    public static RenderObjectManager shared = new RenderObjectManager();

    private List<RenderUnit> units = new LinkedList<>();

    public void addUnitToList(String tag,String texturePath,float width,float height,float x,float y){
        RenderUnit unit = new RenderUnit();
        unit.setTexturePath(texturePath);
        unit.setWidth(width);
        unit.setHeight(height);
        unit.setXposition(x);
        unit.setYposition(y);
        unit.unitTag = tag;
        units.add(unit);
    }

    public void renderAll(){
        for (RenderUnit unit:units
        ) {
            unit.render();

        }
    }

    public void renderOne(String tag){
        for (RenderUnit unit:units
             ) {

            if (unit.unitTag == tag){
                unit.render();
                return;
            }


        }
    }



}
