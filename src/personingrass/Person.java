package personingrass;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;


public class Person {
	
	float x;
	float y;
	boolean moveLeft;
	boolean moveRight;
	int keyRight = Keyboard.KEY_RIGHT;
	int keyLeft = Keyboard.KEY_LEFT;
	
	public Person(float x, float y){
		this.x = x;
		this.y = y;
		moveLeft = false;
		moveRight = false;
	}
	
	public void drawPerson(){
		drawRectangle(new Color(0f,1f,0f, 1f), new Color(0f, .3f, 0f), -1f, -1f, 1f, 1f);
	}
	
	public void update(){
		getKeyInput();
	}
	
	public void getKeyInput() {
		moveLeft = false;
		moveRight = false;
		if (Keyboard.isKeyDown(keyLeft)) {
			moveLeft = true;
		} else if (Keyboard.isKeyDown(keyRight)) {
			moveRight = true;
		}
	}
	
	public static void drawRectangle(Color rgb, Color rgb2, float x, float y, float width, float height){
		// Begin drawing
		GL11.glBegin(GL11.GL_QUADS);
		
		//bottom left
		GL11.glColor4f(rgb2.r, rgb2.g, rgb.b, rgb.a);
		GL11.glVertex2f(x, y);
		
		//top left
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x, y + height);
		
		//top right
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x + width, y + height);
		
		//bottom right
		GL11.glColor4f(rgb2.r, rgb2.g, rgb.b, rgb.a);
		GL11.glVertex2f(x + width, y);

		GL11.glEnd();
	}

}
