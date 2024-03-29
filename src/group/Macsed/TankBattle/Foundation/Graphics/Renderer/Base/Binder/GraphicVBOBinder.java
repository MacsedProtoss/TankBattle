package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GraphicVBOBinder {

    public static GraphicVBOBinder shared = new GraphicVBOBinder();



    public void bindVBO(int vbo, FloatBuffer vertices){
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
//        glBufferSubData(GL_ARRAY_BUFFER,0,vertices);

        glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

    }

    public void unBindVBO(){
        glBindBuffer(GL_ARRAY_BUFFER,0);
    }


}
