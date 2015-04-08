import org.lwjgl.opengl.GL11;


public class Blade {
	float x;
	float y;
	float width;
	float height;
	float sway;
	float alpha;
	
	public Blade(float x, float y, float width, float height, float sway, float alpha){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sway = sway;
		this.alpha = alpha;
	}
	
	public void drawGrass(){
		// Begin drawing
		GL11.glBegin(GL11.GL_TRIANGLES);

		// First triangle
		// Top
		GL11.glColor4f(0.0f, 1.0f, 0.0f, alpha);
		GL11.glVertex2f(x + (float)Math.sin(sway)*(height), y + (float)Math.cos(sway)*(height));

		// Right
		GL11.glColor4f(0.0f, 1.0f, 0.0f, alpha);
		GL11.glVertex2f(x + width/2, y);

		// Left
		GL11.glColor4f(0.0f, 1.0f, 0.0f, alpha);
		GL11.glVertex2f(x - width/2, y);

		GL11.glEnd();
	}
}
