package group.Macsed.TankBattle;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;



public class TriAngle {

    // Function prototypes
    //void key_callback(GLFWwindow window, int key, int scancode, int action, int mode);

// Window dimensions
    private long window;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private int vao,vbo,ebo;
    private String vertexSource , fragmentSource;
    private int shaderProgram;
    private float Xposition,Yposition;
// Shaders



    // The MAIN function, from here we start the application and run the game loop

    public void run() {
        System.out.println("Hello LWJGL " + Version.getVersion() + "!");

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    private void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        Xposition = 0f;
        Yposition = 0f;

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if ( !glfwInit() )
            throw new IllegalStateException("Unable to initialize GLFW");

        // Configure GLFW
        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR,3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR,3);
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(1024, 768, "Learn GLFW!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
        });



        // Get the thread stack and push a new frame
        try ( MemoryStack stack = stackPush() ) {
            IntBuffer pWidth = stack.mallocInt(1); // int*
            IntBuffer pHeight = stack.mallocInt(1); // int*

            // Get the window size passed to glfwCreateWindow
            glfwGetWindowSize(window, pWidth, pHeight);

            // Get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // Center the window
            glfwSetWindowPos(
                    window,
                    (vidmode.width() - pWidth.get(0)) / 2,
                    (vidmode.height() - pHeight.get(0)) / 2
            );
        } // the stack frame is popped automatically

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        glfwSetKeyCallback(window, new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                System.out.println(String.valueOf(key));
                System.out.println(String.valueOf(action));
            }
        });


    }

    private void initObjects(){

        try (MemoryStack stack = MemoryStack.stackPush()) {
            FloatBuffer vertices = stack.mallocFloat(4*5);
            vertices.put(0.1f).put(0.1f).put(0f).put(1.0f).put(1.0f);
            vertices.put(0.1f).put(-0.1f).put(0f).put(1.0f).put(0.0f);
            vertices.put(-0.1f).put(-0.1f).put(0f).put(0.0f).put(0.0f);
            vertices.put(-0.1f).put(0.1f).put(0f).put(0.0f).put(1.0f);
            vertices.flip();

            IntBuffer indices = stack.mallocInt(2*3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

            vao = glGenVertexArrays();
            vbo = glGenBuffers();
            ebo = glGenBuffers();

            glBindVertexArray(vao);

            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ebo);

            glBufferData(GL_ELEMENT_ARRAY_BUFFER,indices,GL_STATIC_DRAW);


            int floatSize = 4;
            int positionAttrib = glGetAttribLocation(shaderProgram,"position");
            System.out.println(glGetError());
            glVertexAttribPointer(0,3,GL_FLOAT,false,5*floatSize,0L);
            System.out.println(glGetError());

            glEnableVertexAttribArray(0);
            System.out.println(glGetError());

            int textureAttrib = glGetAttribLocation(shaderProgram,"texCoord");
            System.out.println(glGetError());
            glVertexAttribPointer(1,2,GL_FLOAT,false,5*floatSize,3*floatSize);
            System.out.println(glGetError());






            glEnableVertexAttribArray(1);
            System.out.println(glGetError());



            glBindBuffer(GL_ARRAY_BUFFER,0);

            glBindVertexArray(0);

//            System.out.println(glGetError());

//            System.out.println("init Object finished");

        }

    }

    private void refreshObjects(){

        Xposition += 0.001f;
        Yposition -= 0.001f;


        try (MemoryStack stack = MemoryStack.stackPush()) {
            FloatBuffer vertices = stack.mallocFloat(4*3);
            vertices.put(0.1f+Xposition).put(0.1f-Yposition).put(0f);
            vertices.put(0.1f+Xposition).put(-0.1f-Yposition).put(0f);
            vertices.put(-0.1f+Xposition).put(-0.1f-Yposition).put(0f);
            vertices.put(-0.1f+Xposition).put(0.1f-Yposition).put(0f);
            vertices.flip();

            IntBuffer indices = stack.mallocInt(2*3);
            indices.put(0).put(1).put(3);
            indices.put(1).put(2).put(3);
            indices.flip();

            vao = glGenVertexArrays();
            vbo = glGenBuffers();
            ebo = glGenBuffers();

            glBindVertexArray(vao);

            glBindBuffer(GL_ARRAY_BUFFER, vbo);
            glBufferData(GL_ARRAY_BUFFER, vertices, GL_STATIC_DRAW);

            glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ebo);
            System.out.println(glGetError());
            glBufferData(GL_ELEMENT_ARRAY_BUFFER,indices,GL_STATIC_DRAW);
            System.out.println(glGetError());

            int floatSize = 4;
            int positionAttrib = glGetAttribLocation(shaderProgram,"position");
            glVertexAttribPointer(positionAttrib,3,GL_FLOAT,false,0,0L);

            glEnableVertexAttribArray(0);

            glBindBuffer(GL_ARRAY_BUFFER,0);

            glBindVertexArray(0);

//            System.out.println(glGetError());

//            System.out.println("init Object finished");

        }

    }





    private void initSource(){
        vertexSource =
                "#version 330 core\n"+
                "layout (location = 0) in vec3 position;\n"+
                "layout (location = 1) in vec2 texCoord;\n"+
                "out vec2 TexCoord;\n"+
                "void main()\n"+
                "{\n"+
                    "gl_Position = vec4(position.x, position.y, position.z, 1.0);\n"+
                    "TexCoord = vec2(texCoord.x,texCoord.y);\n"+
                "}\0";

        fragmentSource =
                "#version 330 core\n"+
                "out vec4 color;\n"+
                "in vec2 TexCoord;\n"+
                "uniform sampler2D texture1;"+
                "void main()\n"+
                "{\n"+
                    "color = texture(texture1,TexCoord);\n"+
                "}\n\0";


//        System.out.println(glGetError());
    }

    private void initShader(){
        int fragmentShader,vertexShader;

        vertexShader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShader, vertexSource);
        glCompileShader(vertexShader);

        int status = glGetShaderi(vertexShader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(vertexShader));
        }

        fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShader, fragmentSource);
        glCompileShader(fragmentShader);

        status = glGetShaderi(fragmentShader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(fragmentShader));
        }

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glBindFragDataLocation(shaderProgram, 0, "color");
        glLinkProgram(shaderProgram);

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        status = glGetProgrami(shaderProgram, GL_LINK_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetProgramInfoLog(shaderProgram));
        }
//        System.out.println(glGetError());
    }

    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        initSource();
        initShader();
        initObjects();

       // Set the clear color
        glClearColor(0.2f, 0.3f, 0.3f, 0.0f);

        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {




            glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glUseProgram(shaderProgram);
//            System.out.println(glGetError());
            glBindVertexArray(vao);

            glDrawElements(GL_TRIANGLES,6,GL_UNSIGNED_INT,0);

//            System.out.println(glGetError());
            glBindVertexArray(0);

//            System.out.println(glGetError());




//            refreshObjects();

            glfwPollEvents();




            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.

        }

        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);

    }





}
