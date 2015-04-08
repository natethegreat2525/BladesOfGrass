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
				GL11.glRotated(0, 0, 0, 1);
				drawTriangles(1);

			}
			GL11.glPopMatrix();
			
			GL11.glPushMatrix(); {
				//calculates value
				double x = Mouse.getX();
				double y = Mouse.getY();
				x = (x / 100) - 3.2;
				y = (y / 100) - 2.4;
				GL11.glTranslated(x, y, 0);
				GL11.glRotated(angle, 0, 0, 1);
				drawTriangles(1);

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

	public static void drawTriangles(float alpha) {
		// Begin drawing
		GL11.glBegin(GL11.GL_TRIANGLES);

		// First triangle
		// Top & Red
		GL11.glColor4f(1.0f, 0.0f, 0.0f, alpha);
		GL11.glVertex2f(0.0f, 1.0f);

		// Right & Green
		GL11.glColor4f(0.0f, 1.0f, 0.0f, alpha);
		GL11.glVertex2f(1.0f, -0.8f);

		// Left & Blue
		GL11.glColor4f(0.0f, 0.0f, 1.0f, 0.5f);
		GL11.glVertex2f(-1.0f, -0.8f);

		GL11.glEnd();
	}

	public static void main(String args[]) {
		OGLTest ct = new OGLTest();
		ct.start();
	}

}