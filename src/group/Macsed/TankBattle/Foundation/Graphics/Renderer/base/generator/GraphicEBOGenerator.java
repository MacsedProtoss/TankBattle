package group.Macsed.TankBattle.Foundation.Graphics.Renderer.base.generator;

import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.opengl.GL33.glGenBuffers;

public class GraphicEBOGenerator {

    public static GraphicEBOGenerator shared;

    public int generateEBO(){
        int ebo = glGenBuffers();
        return ebo;
    }



}
