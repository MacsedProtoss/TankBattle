package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator;

import static org.lwjgl.opengl.GL33.*;

public class GraphicTextureGenerator {

    public static GraphicTextureGenerator shared = new GraphicTextureGenerator();

    public int generateTexture(){
        int texture = glGenTextures();
        return texture;
    }

}
