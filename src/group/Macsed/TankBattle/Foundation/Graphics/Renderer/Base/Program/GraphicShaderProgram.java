package group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Program;

import static org.lwjgl.opengl.GL33.*;

public class GraphicShaderProgram {

    public static GraphicShaderProgram shared = new GraphicShaderProgram();

    public int createProgram(int vertexShader,int fragmentShader){

        int program = glCreateProgram();
        glAttachShader(program, vertexShader);
        glAttachShader(program, fragmentShader);
        glBindFragDataLocation(program, 0, "color");
        glLinkProgram(program);

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        int status = glGetProgrami(program, GL_LINK_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetProgramInfoLog(program));
        }

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);


        return program;
    }

}
