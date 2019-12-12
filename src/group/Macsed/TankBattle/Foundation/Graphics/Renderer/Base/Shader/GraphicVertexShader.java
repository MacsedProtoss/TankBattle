package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Shader;

import static org.lwjgl.opengl.GL33.GL_TRUE;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.opengl.GL33.glCompileShader;
import static org.lwjgl.opengl.GL33.glShaderSource;
import static org.lwjgl.opengl.GL33.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL33.glCreateShader;

public class GraphicVertexShader {

    public static GraphicVertexShader shared = new GraphicVertexShader();

    public int createShader(String source){
        int shader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(shader, source);
        glCompileShader(shader);
        int status = glGetShaderi(shader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(shader));
        }

        return shader;
    }





}
