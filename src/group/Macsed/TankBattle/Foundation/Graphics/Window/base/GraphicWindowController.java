package group.Macsed.TankBattle.Foundation.Graphics.Window.base;

import group.Macsed.TankBattle.Foundation.Graphics.GraphicCommonValues;
import group.Macsed.TankBattle.Foundation.Graphics.Renderer.ObjectDrawer.Base.RenderUnitManager;
import group.Macsed.TankBattle.Foundation.Graphics.Window.GraphicResourcesManager;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyBoardEventManager;
import group.Macsed.TankBattle.Foundation.Keyboard.KeyboardActiveKeys;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GraphicWindowController {

    protected long window;
    protected GraphicResourcesManager resourcesManager;

    public GraphicResourcesManager getResourcesManager() {
        return resourcesManager;
    }

    public void setResourcesManager(GraphicResourcesManager resourcesManager) {
        this.resourcesManager = resourcesManager;
    }

    public void run() {
        System.out.println("Now Loading Basic Window");

        init();
        loop();

        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();

    }

    protected void init() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
//        Configuration.DEBUG_MEMORY_ALLOCATOR.set(true);

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
        window = glfwCreateWindow(GraphicCommonValues.shared.ScreenWidth(), GraphicCommonValues.shared.ScreenHeight(), "Learn GLFW!", NULL, NULL);
        if ( window == NULL )
            throw new RuntimeException("Failed to create the GLFW window");

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
            if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE ) {
                glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
            }

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
                if (key == GLFW_KEY_W){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.w);
                }

                if (key == GLFW_KEY_A){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.a);
                }

                if (key == GLFW_KEY_S){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.s);
                }

                if (key == GLFW_KEY_D){
                    KeyBoardEventManager.shared.handleKeyEvent(KeyboardActiveKeys.d);
                }
            }
        });


    }


    protected void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();


        // Set the clear color
        glClearColor(0.2f, 0.3f, 0.3f, 0.0f);


        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        while ( !glfwWindowShouldClose(window) ) {


            glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer



            updateAndDraw();



            glfwPollEvents();



            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.

        }


    }

    //TODO: this is a draw test & should be removed once test passed
    protected void updateAndDraw(){
        RenderUnitManager.shared.renderAll();
    }



}
