import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class OGLTest {
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		ArrayList<Blade> listOfBlades = new ArrayList<Blade>();
		Blade testBlade;
		for(int i = 0; i < 100; i++){
			testBlade = new Blade((float)Math.random()*6.8f - 3.4f, 0, .1f, .5f, (float)Math.random() -.5f, .5f, 0.01f);
			listOfBlades.add(testBlade);
		}
		// Init OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(-3.2, 3.2, -2.4, 2.4, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		//THIS LINE
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		boolean quit = false;
		double angle = 0;

		while (!quit) {
			angle += .5;
			// Clear the screen.
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

			GL11.glPushMatrix(); {
				for(Blade current : listOfBlades){
					current.drawGrass();
					current.update();
				}
			}
			GL11.glPopMatrix();
			
			Display.sync(60);
			Display.update();

			if (Display.isCloseRequested()
					|| Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
				quit = true;
		}

		Display.destroy();
	}

	
	public static void main(String args[]) {
		OGLTest ct = new OGLTest();
		ct.start();
	}

}