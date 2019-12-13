package group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Tank.GraphicTankUnit;

import java.util.LinkedList;
import java.util.List;

public class RenderUnitManager {

    public static RenderUnitManager shared = new RenderUnitManager();

    public List<RenderUnit> units = new LinkedList<>();

    public void addUnitToList(String tag,String texturePath,float width,float height,float x,float y,RenderUnitType type){

        if (type == RenderUnitType.tank){
            GraphicTankUnit unit = new GraphicTankUnit();
            unit.setData(new RenderDataUnit(texturePath,x,y,width,height));
            unit.unitTag = tag;
            unit.type = type;
            units.add(unit);
        }else{
            RenderUnit unit = new RenderUnit();
            unit.setData(new RenderDataUnit(texturePath,x,y,width,height));
            unit.unitTag = tag;
            unit.type = type;
            units.add(unit);
        }

    }

    public void clearList(){
        units = new LinkedList<>();
    }

    public void renderAll(){
        for (RenderUnit unit:units
        ) {

            if (unit.type == RenderUnitType.map){
                unit.render();
            }

            if (unit.shouldBeRecycled){
                units.remove(unit);
            }

        }

        for (RenderUnit unit:units
        ) {

            if (unit.type == RenderUnitType.tank){
                GraphicTankUnit tank = (GraphicTankUnit) unit;
                if (tank.isExpoding){
                    tank.renderExplode();
                }else{
                    tank.render();
                }
            }

        }


        for (RenderUnit unit:units
             ) {

            if (unit.type != RenderUnitType.map && unit.type != RenderUnitType.tank){
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
