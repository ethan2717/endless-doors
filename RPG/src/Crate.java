import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Crate extends GameObject {
	private static BufferedImage a;
	private static BufferedImage b;
	private static BufferedImage c;
	public Crate(double x, double y, int w, int h) {
		super(x, y, w, h, false, false, 20, "sprites/crate.png");
		a= GameObject.tint(this.image, Color.DARK_GRAY);
		b=GameObject.tint(a, Color.DARK_GRAY);
		c=GameObject.tint(b, Color.DARK_GRAY);
	}
	
	@Override
	public void draw(Graphics g) {
		double curr = this.getHealthPercent();
		if (curr>.75) {
			super.draw(g);
		}else if(curr>.5) {
			super.draw(g,a);
		}else if (curr>.25) {
			super.draw(g, b);
		} else {
			super.draw(g, c);
		}
		
	}

}
