package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Shader;


import static org.lwjgl.opengl.GL33.*;

public class GraphicFragmentShader {

    public static GraphicFragmentShader shared;

    public int createFragmentShader(String source){
        int shader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(shader, source);
        glCompileShader(shader);

        int status = glGetShaderi(shader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(shader));
        }

        return shader;
    }

}
