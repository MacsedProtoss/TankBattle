package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder;

import group.Macsed.TankBattle.Foundation.Graphics.Utils.GraphicImageUtil;

import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.stb.STBImageResize.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GraphicTextureBinder {

    public static GraphicTextureBinder shared = new GraphicTextureBinder();

    public void bindTexture(int texture,String imagePath){
        glBindTexture(GL_TEXTURE_2D,texture);

        glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_S,GL_REPEAT);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

        GraphicImageUtil.shared.readImage(imagePath);

        glTexImage2D(GL_TEXTURE_2D,0,GL_RGB,GraphicImageUtil.shared.getWidth(),GraphicImageUtil.shared.getHeight(),0,GL_RGB,GL_UNSIGNED_BYTE,GraphicImageUtil.shared.getImage());



        glGenerateMipmap(GL_TEXTURE_2D);

        unbindTexture();

    }

    public void unbindTexture(){
        glBindTexture(GL_TEXTURE_2D,0);
    }

}
