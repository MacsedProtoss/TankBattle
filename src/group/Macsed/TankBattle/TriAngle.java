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
    final int WIDTH = 800;
    final int HEIGHT = 600;
    int vao,vbo,ebo;
    String vertexSource , fragmentSource;
    int shaderProgram;

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




    }

    private void initObjects(){

        try (MemoryStack stack = MemoryStack.stackPush()) {
            FloatBuffer vertices = stack.mallocFloat(4*3);
            vertices.put(0.5f).put(0.5f).put(0f);
            vertices.put(0.5f).put(-0.5f).put(0f);
            vertices.put(-0.5f).put(-0.5f).put(0f);
            vertices.put(-0.5f).put(0.5f).put(0f);
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

            glBindBuffer(GL_ARRAY_BUFFER,ebo);
            glBufferData(GL_ARRAY_BUFFER,indices,GL_STATIC_DRAW);

            int floatSize = 4;
            int positionAttrib = glGetAttribLocation(shaderProgram,"position");
            glVertexAttribPointer(positionAttrib,3,GL_FLOAT,false,3*floatSize,0);

            glEnableVertexAttribArray(0);

            glBindBuffer(GL_ARRAY_BUFFER,0);

            glBindVertexArray(0);

            System.out.println("init Object finished");

        }

    }





    private void initSource(){
        vertexSource = "#version 330 core\n"+
        "layout (location = 0) in vec3 position;\n"+
        "void main()\n"+
        "{\n"+
        "gl_Position = vec4(position.x, position.y, position.z, 1.0);\n"+
        "}\0";

        fragmentSource ="#version 330 core\n"+
        "out vec4 color;\n"+
        "void main()\n"+
        "{\n"+
        "color = vec4(1.0f, 0.5f, 0.2f, 1.0f);\n"+
        "}\n\0";


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
        glBindFragDataLocation(shaderProgram, 0, "fragColor");
        glLinkProgram(shaderProgram);

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        status = glGetProgrami(shaderProgram, GL_LINK_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetProgramInfoLog(shaderProgram));
        }
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
            glfwPollEvents();

            glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glUseProgram(shaderProgram);
            glBindVertexArray(vao);
            //glDrawArrays(GL_TRIANGLES,0,6);
            glDrawElements(GL_TRIANGLES,6,GL_UNSIGNED_INT,0);
            glBindVertexArray(0);
            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.

        }

        glDeleteVertexArrays(vao);
        glDeleteBuffers(vbo);
        glDeleteBuffers(ebo);

    }




}
