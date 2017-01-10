

import java.awt.Color;

import guis.components.Action;
import guis.components.Clickable;

public interface ButtonInterfaceSimon extends Clickable {

	void setColor(Color color);

	void setX(int i);

	void setY(int i);

	void setAction(Action action);
	
	void highlight();
	
	void dim();

	

	


}
