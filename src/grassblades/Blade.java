package grassblades;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;


public class Blade {
	float x;
	float y;
	float width;
	float height;
	float sway;
	float alpha;
	float swayVelocity;
	
	Color rgb;
	
	public Blade(float x, float y, float width, float height, float sway, float alpha, float swayVelocity, Color rgb){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sway = sway;
		this.alpha = alpha;
		this.swayVelocity = swayVelocity;
		this.rgb = rgb;
	}
	
	public void drawGrass(){
		// Begin drawing
		GL11.glBegin(GL11.GL_TRIANGLES);

		// First triangle
		// Top
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, alpha);
		GL11.glVertex2f(x + (float)Math.sin(sway)*(height), y + (float)Math.cos(sway)*(height));

		// Right
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, alpha);
		GL11.glVertex2f(x + width/2, y);

		// Left
		GL11.glColor4f(rgb.r, rgb.g, rgb.b, alpha);
		GL11.glVertex2f(x - width/2, y);

		GL11.glEnd();
	}
	
	public void update(float x, float y, float vx, float vy){
		float dx = this.x - x;
		float dy = this.y - y;
		float dist = (float) Math.sqrt(dx*dx + dy*dy*3f);
		
		if (dist < 1) {
			float targ = (float) (1-dist);
			if (dx < 0)
				targ = -targ;
			
			sway = sway*.6f + targ*.4f;
			swayVelocity *= .9f;
		}
		
		sway += swayVelocity;
		if(sway > 0){
			swayVelocity -= sway*.03f; 
		}else{
			swayVelocity -= sway*.03f;
		}
		swayVelocity *= .99f;
	}
}
