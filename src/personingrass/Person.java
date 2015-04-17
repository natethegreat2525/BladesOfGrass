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
	Color color;
	
	public Person(float x, float y, Color color){
		this.x = x;
		this.y = y;
		this.color = color;
		moveLeft = false;
		moveRight = false;
	}
	
	public void drawPerson(){
		drawRectangle(color, x, y, .5f, .5f);
	}
	
	public void update(){
		getKeyInput();
		if(moveLeft){
			x = x - .02f;
		}
		if(moveRight){
			x = x + .02f;
		}
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
	
	public static void drawRectangle(Color rgb,  float x, float y, float width, float height){
		// Begin drawing
		GL11.glBegin(GL11.GL_QUADS);
		
		//bottom left
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x, y);
		
		//top left
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x, y + height);
		
		//top right
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x + width, y + height);
		
		//bottom right
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, rgb.a);
		GL11.glVertex2f(x + width, y);

		GL11.glEnd();
	}

}
