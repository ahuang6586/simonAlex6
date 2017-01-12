package partnerCodeHerePlease;

import guis.components.Action;
import simonAlex.ButtonInterfaceSimon;
import guis.components.Component;

import java.awt.*;

public class Button extends Component implements ButtonInterfaceSimon {
	private int x, y;
	private Color color; // color depending at state.
	private Color hColor; // keep track of color of original button for highlighted state.
	private Action action;


	public Button(int x, int y, int w, int h, Color color) {
		super(x, y, w, h);
		setColor(color); // current color.
		setHColor(color); // color for highlighted state.
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getColor());
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
		FontMetrics fm = g.getFontMetrics();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
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
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public void setY(int y) {
		this.y = y;
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
	public void highlight() {
		setColor(getHColor()); // could've used color/this.color as the argument, but it looks sloppy.
		update();
	}

	@Override
	public boolean isHovered(int x, int y) { // check if mouse is over component.
		return (x >= getX() && x <= (getX() + getWidth()) && y >= getY() && y <= (getY() + getHeight()));
	}

	@Override
	public void act() {
		this.action.act();
	}
}
