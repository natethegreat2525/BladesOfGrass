import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

public class OGLPerson {
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
		Person testPerson = new Person(0, 0);
		
		int numBlades = 1000;
		for(int i = 0; i < numBlades; i++){
			float depth = ((float)numBlades-i)/numBlades;
			Color c = new Color(.1f, depth*.7f + .3f, .1f);
			float vel = (float) Math.random()*.05f;
			testBlade = new Blade((float)Math.random()*6.8f - 3.4f, -2.5f, .1f*(1.5f-depth), .5f*(1.5f-depth), (float)Math.random() -.5f, .8f, vel, c);
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
		GL11.glClearColor(100/255f, 149/255f, 237/255f, 1);
		
		boolean quit = false;
		double angle = 0;

		while (!quit) {
			angle += .5;
			// Clear the screen.
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			//drawRectangle(new Color(0f,1f,0f, 1f), new Color(0f, .3f, 0f), -3.4f, -2.4f, 6.8f, 1.4f);
			GL11.glPushMatrix(); {
				float x = Mouse.getX()/100f - 3.2f;
				float y = Mouse.getY()/100f - 2.4f;
				float dx = Mouse.getDX()/100f;
				float dy = Mouse.getDY()/100f;
				for(Blade current : listOfBlades){
					current.drawGrass();
					current.update(x, y, dx, dy);
				}
			}
			
			GL11.glPushMatrix(); {
				float x = Mouse.getX()/100f - 3.2f;
				float y = Mouse.getY()/100f - 2.4f;
				float dx = Mouse.getDX()/100f;
				float dy = Mouse.getDY()/100f;
				testPerson.drawPerson();
				testPerson.update(x, y);
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
		OGLPerson ct = new OGLPerson();
		ct.start();
	}

}