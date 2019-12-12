package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator;

import static org.lwjgl.opengl.GL33.*;


public class GraphicVBOGenerator {

    public static GraphicVBOGenerator shared;

    public int generateVBO(){
        int vbo = glGenBuffers();
        return vbo;
    }

}
