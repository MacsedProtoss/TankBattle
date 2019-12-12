package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator;

import static org.lwjgl.opengl.GL33.glGenBuffers;

public class GraphicEBOGenerator {

    public static GraphicEBOGenerator shared;

    public int generateEBO(){
        int ebo = glGenBuffers();
        return ebo;
    }

}
