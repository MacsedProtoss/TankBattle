package group.Macsed.TankBattle.Model.GameData;

import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class GameObject {

    private FloatBuffer vertices;
    private IntBuffer indices;
    private float positionX;
    private float positionY;
    private float width;
    private float height;
    private GameObjectType ObjectType;

    protected GameObject(){
        positionX = 0;
        positionY = 0;
        width = 0;
        height = 0;
        try (MemoryStack stack = MemoryStack.stackPush()) {
            vertices = stack.mallocFloat(4*3);
            vertices.put(0f).put(0f).put(0f);
            vertices.put(0f).put(0f).put(0f);
            vertices.put(0f).put(0f).put(0f);
            vertices.put(0f).put(0f).put(0f);
            vertices.flip();

            indices = stack.mallocInt(2*3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

        }

    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
        refreshRects();

    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
        refreshRects();
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setType(GameObjectType type) {
        this.ObjectType = type;
    }

    public GameObjectType getType() {
        return ObjectType;
    }

    public FloatBuffer getVertices() {
        return vertices;
    }

    public IntBuffer getIndices() {
        return indices;
    }

    private void refreshRects(){
        try (MemoryStack stack = MemoryStack.stackPush()) {
            vertices = stack.mallocFloat(4*3);
            vertices.put(positionX).put(positionY).put(0f);
            vertices.put(positionX+width).put(positionY).put(0f);
            vertices.put(positionX+width).put(positionY+height).put(0f);
            vertices.put(positionX).put(positionY+height).put(0f);
            vertices.flip();

        }
    }

}
