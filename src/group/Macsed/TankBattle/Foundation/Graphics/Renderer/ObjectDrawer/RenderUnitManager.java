package group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataUnit;

import java.util.LinkedList;
import java.util.List;

public class RenderUnitManager {

    public static RenderUnitManager shared = new RenderUnitManager();

    private List<RenderUnit> units = new LinkedList<>();

    public void addUnitToList(String tag,String texturePath,float width,float height,float x,float y){
        RenderUnit unit = new RenderUnit();
        unit.setData(new RenderDataUnit(texturePath,x,y,width,height));
        unit.unitTag = tag;
        units.add(unit);
    }

    public void renderAll(){
        for (RenderUnit unit:units
        ) {

            if (unit.unitTag == "map"){
                unit.render();
            }

        }

        for (RenderUnit unit:units
        ) {

            if (unit.unitTag != "map"){
                unit.render();
            }

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

    public RenderUnit getPlayer(){
        for (RenderUnit unit:units
        ) {

            if (unit.unitTag == "player"){

                return unit;
            }


        }

        return null;
    }



}
