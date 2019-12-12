package group.Macsed.TankBattle.Foundation.Graphics.Renderer.base.binder;

import static org.lwjgl.opengl.GL33.glBindVertexArray;

public class GraphicVAOBinder {

    public static GraphicVAOBinder shared;

    public void bindVao(int vao){
        glBindVertexArray(vao);
    }

    public void unbindVAO(){
        glBindVertexArray(0);
    }

}
