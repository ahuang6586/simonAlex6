package partnerCodeHerePlease;

import gui.components.Action;
import simonAlex.ButtonInterfaceSimon;
import gui.components.Components;

import java.awt.*;

public class Button extends Components implements ButtonInterfaceSimon {
	private int x, y;
	private Color color; // color depending at state.
	private Color hColor; // keep track of color of original button for highlighted state.
	private Action action;


	public Button(int x, int y, int w, int h, Color color) {
		super(x, y, w, h);
		System.out.println("COLORS NOT SET");
		this.color = color; // current color.
		this.hColor = color; // color for highlighted state.
		System.out.println("DONECONST");
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// since update will be called before colors are set(in the constructor), we must make sure to only set their
		// color if they have one.
		if(getColor() == null) g.setColor(Color.BLACK);
		else {
			//System.out.println("Color SET: " + getColor() + "x: " + getX() + ", y: " + getY() + "\nw: " + getWidth() + " h: " + getHeight());
			g.setColor(getColor()); // if it was initiated, set it.
		}
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}


	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setHColor(Color color) {
		hColor = color;
	}

	@Override
	public Color getHColor() {
		return hColor;
	}


	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void dim() {
		setColor(Color.BLACK); // default color will be black.
		update(); // make sure to update new states.
	}

	@Override
	public boolean isLit() {
		return (getColor() == hColor);
	}

	@Override
	public void highlight() {
		setColor(getHColor()); // could've used color/this.color as the argument, but it looks sloppy.
		update();
	}

	/*@Override
	public boolean isHovered(int x, int y) { // check if mouse is over component.
		return (x >= getX() && x <= (getX() + getWidth()) && y >= getY() && y <= (getY() + getHeight()));
	}*/
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+50/2), 2)+Math.pow(y-(getY()+50/2), 2));
		return distance < 50/2;
	}

	@Override
	public void act() {
		action.act();
	}

}
