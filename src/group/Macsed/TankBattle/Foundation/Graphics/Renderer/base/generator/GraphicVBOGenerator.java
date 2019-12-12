package group.Macsed.TankBattle.Foundation.Graphics.Renderer.base.generator;

import static org.lwjgl.opengl.GL33.*;


public class GraphicVBOGenerator {

    public static GraphicVBOGenerator shared;

    public int generateVBO(){
        int vbo = glGenBuffers();
        return vbo;
    }

}
