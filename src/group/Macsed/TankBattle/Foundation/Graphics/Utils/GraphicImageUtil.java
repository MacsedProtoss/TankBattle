package group.Macsed.TankBattle.Foundation.Graphics.Utils;

import org.lwjgl.system.MemoryStack;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static group.Macsed.TankBattle.Foundation.File.FileIOUtil.ioResourceToByteBuffer;
import static java.lang.Math.round;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.stb.STBImage.*;
import static org.lwjgl.stb.STBImageResize.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GraphicImageUtil {

    private ByteBuffer image;
    private int width;
    private int height;
    private int comp;
    private int format;
    private String imagePath;

    public ByteBuffer getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getComp() {
        return comp;
    }

    public int getFormat() {
        return format;
    }

    public static GraphicImageUtil shared = new GraphicImageUtil();

    public void readImage(String imagePath) {

        ByteBuffer imageBuffer = null;

        try {
            imageBuffer = ioResourceToByteBuffer(imagePath, 8 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (MemoryStack stack = stackPush()) {
            IntBuffer w = stack.mallocInt(1);
            IntBuffer h = stack.mallocInt(1);
            IntBuffer comp = stack.mallocInt(1);

            // Use info to read image metadata without decoding the entire image.
            // We don't need this for this demo, just testing the API.
            if (!stbi_info_from_memory(imageBuffer, w, h, comp)) {
                throw new RuntimeException("Failed to read image information: " + stbi_failure_reason());
            } else {
                System.out.println("OK with reason: " + stbi_failure_reason());
            }

            System.out.println("Image width: " + w.get(0));
            System.out.println("Image height: " + h.get(0));
            System.out.println("Image components: " + comp.get(0));
            System.out.println("Image HDR: " + stbi_is_hdr_from_memory(imageBuffer));

            // Decode the image
            this.image = stbi_load_from_memory(imageBuffer, w, h, comp, 0);

            if (image == null) {
                throw new RuntimeException("Failed to load image: " + stbi_failure_reason());
            }

            this.width = w.get(0);
            this.height = h.get(0);
            this.comp = comp.get(0);

        }

//        memFree(imageBuffer);
//        if (comp == 3) {
//            if ((width & 3) != 0) {
//                glPixelStorei(GL_UNPACK_ALIGNMENT, 2 - (width & 1));
//            }
//            format = GL_RGB;
//        } else {
////            premultiplyAlpha();
//
//            glEnable(GL_BLEND);
//            glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
//
//            format = GL_RGBA;
//        }

//        free();
    }

    private void premultiplyAlpha() {
        int stride = width * 4;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int i = y * stride + x * 4;

                float alpha = (image.get(i + 3) & 0xFF) / 255.0f;
                image.put(i + 0, (byte)round(((image.get(i + 0) & 0xFF) * alpha)));
                image.put(i + 1, (byte)round(((image.get(i + 1) & 0xFF) * alpha)));
                image.put(i + 2, (byte)round(((image.get(i + 2) & 0xFF) * alpha)));
            }
        }
    }

    public void free(){
        stbi_image_free(image);
    }

}