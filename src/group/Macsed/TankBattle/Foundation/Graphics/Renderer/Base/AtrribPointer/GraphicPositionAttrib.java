package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.AtrribPointer;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;

import static org.lwjgl.opengl.GL33.*;

public class GraphicPositionAttrib {

    public static GraphicPositionAttrib shared = new GraphicPositionAttrib();

    public void attribPosition(int program){
        int locationAtrrib = glGetAttribLocation(program,"position");
        glVertexAttribPointer(locationAtrrib,3,GL_FLOAT,false,5* GraphicCommonValues.shared.floatSize(),0L);
        glEnableVertexAttribArray(locationAtrrib);

    }

}
