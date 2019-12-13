package group.Macsed.TankBattle.Foundation.Graphics;

import group.Macsed.TankBattle.Main;

public class GraphicCommonValues {

    public static GraphicCommonValues shared = new GraphicCommonValues();

    public int floatSize(){
        return 4;
    }

    public String vertexShaderWithTexture(){
        return"#version 330 core\n" +
                "layout (location = 0) in vec3 position;\n" +
                "layout (location = 1) in vec2 texCoord;\n" +
                "\n" +
                "out vec2 TexCoord;\n" +
                "\n" +
                "void main()\n" +
                "{\n" +
                "\tgl_Position = vec4(position, 1.0f);\n" +
                "\t// We swap the y-axis by substracing our coordinates from 1. This is done because most images have the top y-axis inversed with OpenGL's top y-axis.\n" +
                "\t// TexCoord = texCoord;\n" +
                "\tTexCoord = vec2(texCoord.x, 1.0 - texCoord.y);\n" +
                "}";
    }

    public String fragmentShaderWithTexture(){
        return "#version 330 core\n" +
                "in vec2 TexCoord;\n" +
                "\n" +
                "out vec4 color;\n" +
                "\n" +
                "// Texture samplers\n" +
                "uniform sampler2D ourTexture1;\n" +
                "\n" +
                "void main()\n" +
                "{\n" +
                "\t// Linearly interpolate between both textures (second texture is only slightly combined)\n" +
                "\tcolor = texture(ourTexture1, TexCoord);\n" +
                "}";
    }

    public float moveSpeed(){
        return 0.01f;
    }

    public int ScreenWidth(){
        return 1280;
    }

    public int ScreenHeight(){
        return 720;
    }

    public int BulletSize(){
        return 4;
    }

    public int CommonObjSize(){
        return 64;
    }

    public int enermyDamage(){
        return 10;
    }

    public int playerDamage(){
        return 10;
    }

    public int enermyHelath(){
        return 70;
    }

    public int playerHealth(){
        return 200;
    }

    public String classpath(){
//        return Main.class.getResource("").toString();
        return "/Volumes/MacData/codes/JavaProjects/TankBattle/src/group/Macsed/TankBattle/";
    }




}
