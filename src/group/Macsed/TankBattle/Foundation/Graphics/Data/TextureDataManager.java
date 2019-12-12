package group.Macsed.TankBattle.Foundation.Graphics.Data;

import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder.GraphicTextureBinder;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator.GraphicTextureGenerator;

import java.util.*;

public class TextureDataManager {

    private Map<String,Integer> textures = new HashMap<>();

    private final List<String> paths = new LinkedList<>(){{
        add("/Volumes/DATA/3.png");
        add("/Volumes/DATA/1.png");
    }};

    public static TextureDataManager shared = new TextureDataManager();

    public void init(){
        if (textures.isEmpty()){
            loadImage();
        }
    }

    private void loadImage(){
        for (String path :
                paths) {

            int texture = GraphicTextureGenerator.shared.generateTexture();
            GraphicTextureBinder.shared.bindTexture(texture,path);

            textures.put(path,texture);

        }
    }

    public int getTexture(String path){
        if (textures.containsKey(path)){
            return textures.get(path);
        }

        return 0;
    }

}
