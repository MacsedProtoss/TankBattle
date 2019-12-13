package group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base;

import group.Macsed.TankBattle.Foundation.Graphics.Data.TextureDataManager;
import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.AtrribPointer.GraphicPositionAttrib;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.AtrribPointer.GraphicTextureAttrib;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder.GraphicEBOBinder;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder.GraphicTextureBinder;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder.GraphicVAOBinder;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Binder.GraphicVBOBinder;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator.GraphicEBOGenerator;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator.GraphicTextureGenerator;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator.GraphicVAOGenerator;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Generator.GraphicVBOGenerator;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Program.GraphicShaderProgram;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Shader.GraphicFragmentShader;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.Base.Shader.GraphicVertexShader;


import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.opengl.GL33.*;

public class GraphicBaseDrawer {

    private String texturePath;
    private FloatBuffer vertices;
    private IntBuffer indices;

    private int vao;
    private int vbo;
    private int ebo;
    private int vertexShader;
    private int fragmentShader;
    private int program;
    private int texture;

    public static GraphicBaseDrawer shared = new GraphicBaseDrawer();

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    public void setVertices(FloatBuffer vertices) {
        this.vertices = vertices;
    }

    public void setIndices(IntBuffer indices) {
        this.indices = indices;
    }

    private void init() {

        this.vao = GraphicVAOGenerator.shared.generateVao();
        this.vbo = GraphicVBOGenerator.shared.generateVBO();
        this.ebo = GraphicEBOGenerator.shared.generateEBO();

        this.vertexShader = GraphicVertexShader.shared.createShader(GraphicCommonValues.shared.vertexShaderWithTexture());
        this.fragmentShader = GraphicFragmentShader.shared.createFragmentShader(GraphicCommonValues.shared.fragmentShaderWithTexture());
        this.program = GraphicShaderProgram.shared.createProgram(vertexShader, fragmentShader);


        TextureDataManager.shared.init();
        this.texture = TextureDataManager.shared.getTexture(texturePath);
    }

    public void bindObjects() {

        GraphicVAOBinder.shared.bindVao(vao);
        GraphicVBOBinder.shared.bindVBO(vbo, vertices);
        GraphicEBOBinder.shared.bindEBO(ebo, indices);

        GraphicPositionAttrib.shared.attribPosition(program);
        GraphicTextureAttrib.shared.attribLocation(program);




        GraphicVAOBinder.shared.unbindVAO();
    }

    public void draw() {

        init();
        bindObjects();

        glUseProgram(program);


        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, texture);
        glUniform1i(glGetUniformLocation(program, "ourTexture1"), 0);


        glBindVertexArray(vao);

        glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);

        glBindVertexArray(0);

        delete();

    }

    public void delete() {
        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);
        glDeleteProgram(program);
    }

}
