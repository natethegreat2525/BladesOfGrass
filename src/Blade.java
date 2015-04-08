import org.lwjgl.opengl.GL11;


public class Blade {
	float x;
	float y;
	float width;
	float height;
	float sway;
	float alpha;
	float swayVelocity;
	
	public Blade(float x, float y, float width, float height, float sway, float alpha, float swayVelocity){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sway = sway;
		this.alpha = alpha;
		this.swayVelocity = swayVelocity;
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
	
	public void update(){
		sway += swayVelocity;
		if(sway > 0){
			swayVelocity -= .01f; 
		}else{
			swayVelocity += .01f;
		}
	}
}
