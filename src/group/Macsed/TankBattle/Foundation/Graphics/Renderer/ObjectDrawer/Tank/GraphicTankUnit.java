package group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Tank;

import group.Macsed.TankBattle.Foundation.Graphics.Data.RenderDataUnit;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.GraphicBaseDrawer;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnit;
import org.lwjgl.system.MemoryStack;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.List;

import static org.lwjgl.system.MemoryStack.stackPush;

public class GraphicTankUnit extends RenderUnit {

    private RenderDataUnit explodData;
    private List<String> explodImagePaths;
    private int currentImageIndex = 0;
    public boolean isExpoding;

    public void setExplodImagePaths(List<String> explodImagePaths) {
        this.explodImagePaths = explodImagePaths;
    }

    public void renderExplode(){
        if (explodData == null){
            explodData = new RenderDataUnit(explodImagePaths.get(0),getData().Xposition,getData().Yposition,getData().width,getData().height);
        }else{
            if (currentImageIndex < explodImagePaths.size()){
                currentImageIndex += 1;
            }else{
                shouldBeRecycled = true;
            }
            explodData.path = explodImagePaths.get(currentImageIndex);
        }


        try (MemoryStack stack = stackPush() ) {

            FloatBuffer vertices;
            IntBuffer indices;

            vertices = stack.mallocFloat(4 * 5);
            vertices.put(explodData.width+explodData.Xposition).put(explodData.height+explodData.Yposition).put(0f).put(explodData.anchors[0]).put(explodData.anchors[1]);
            vertices.put(explodData.width+explodData.Xposition).put(-explodData.height+explodData.Yposition).put(0f).put(explodData.anchors[2]).put(explodData.anchors[3]);
            vertices.put(-explodData.width+explodData.Xposition).put(-explodData.height+explodData.Yposition).put(0f).put(explodData.anchors[4]).put(explodData.anchors[5]);
            vertices.put(-explodData.width+explodData.Xposition).put(explodData.height+explodData.Yposition).put(0f).put(explodData.anchors[6]).put(explodData.anchors[7]);
            vertices.flip();

            indices = stack.mallocInt(2 * 3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

            GraphicBaseDrawer.shared.setIndices(indices);
            GraphicBaseDrawer.shared.setVertices(vertices);
            GraphicBaseDrawer.shared.setTexturePath(explodData.path);
            GraphicBaseDrawer.shared.draw();


        }

    }

}
