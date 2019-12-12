package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GraphicEBOBinder {

    public static GraphicEBOBinder shared;

    public void bindEBO(int ebo,IntBuffer indices){
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ebo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,indices,GL_STATIC_DRAW);
    }

    public void unBindEBO(){
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,0);
    }

}
