package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.AtrribPointer;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;

import static org.lwjgl.opengl.GL33.*;

public class GraphicTextureAttrib {

    public static GraphicTextureAttrib shared = new GraphicTextureAttrib();

    public void attribLocation(int program){
        int locationAttrib = glGetAttribLocation(program,"texCoord");
        glVertexAttribPointer(locationAttrib,2,GL_FLOAT,false,5* GraphicCommonValues.shared.floatSize(),3*GraphicCommonValues.shared.floatSize());
        glEnableVertexAttribArray(locationAttrib);

    }


}
