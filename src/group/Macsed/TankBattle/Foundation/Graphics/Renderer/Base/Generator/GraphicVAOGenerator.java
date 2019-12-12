package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator;

import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class GraphicVAOGenerator {

    public static GraphicVAOGenerator shared;

    public int generateVao(int vaoID){
        int vao = glGenVertexArrays();
        return vao;
    }

}
