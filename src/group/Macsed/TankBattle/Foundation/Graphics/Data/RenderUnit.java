package group.Macsed.TankBattle.Foundation.Graphics.Data;

import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.GraphicBaseDrawer;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Random;

import static org.lwjgl.system.MemoryStack.stackPush;

public class RenderUnit {

    public String unitTag;

    private float Xposition;
    private float Yposition;

    private float width;
    private float height;

    private String texturePath;

    private boolean hasSub = false;
    private float subXposition;
    private float subYposition;

    private float subWidth;

    public void setHasSub(boolean hasSub) {
        this.hasSub = hasSub;
    }

    private float subHeight;
    private String subTexturePath;


    public void setXposition(float xposition) {
        Xposition = xposition;
    }

    public void setYposition(float yposition) {
        Yposition = yposition;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public void setSubXposition(float subXposition) {
        this.subXposition = subXposition;
    }

    public void setSubYposition(float subYposition) {
        this.subYposition = subYposition;
    }

    public void setSubWidth(float subWidth) {
        this.subWidth = subWidth;
    }

    public void setSubHeight(float subHeight) {
        this.subHeight = subHeight;
    }

    public void setSubTexturePath(String subTexturePath) {
        this.subTexturePath = subTexturePath;
    }

    public void render(){

        try (MemoryStack stack = stackPush() ) {

            FloatBuffer vertices;
            IntBuffer indices;

            vertices = stack.mallocFloat(4 * 5);
            vertices.put(width+Xposition).put(height+Yposition).put(0f).put(1.0f).put(1.0f);
            vertices.put(width+Xposition).put(-height+Yposition).put(0f).put(1.0f).put(0.0f);
            vertices.put(-width+Xposition).put(-height+Yposition).put(0f).put(0.0f).put(0.0f);
            vertices.put(-width+Xposition).put(height+Yposition).put(0f).put(0.0f).put(1.0f);
            vertices.flip();

            indices = stack.mallocInt(2 * 3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

            GraphicBaseDrawer.shared.setIndices(indices);
            GraphicBaseDrawer.shared.setVertices(vertices);
            GraphicBaseDrawer.shared.setTexturePath(texturePath);
            GraphicBaseDrawer.shared.draw();



        }


    }




}
