package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator;

import static org.lwjgl.opengl.GL33.*;

public class GraphicVAOGenerator {

    public static GraphicVAOGenerator shared = new GraphicVAOGenerator();

    public int generateVao(){
        int vao = glGenVertexArrays();

        return vao;
    }

}
