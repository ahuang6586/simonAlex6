package simonAlex;

import GUI.GUIApplication;

@SuppressWarnings("serial")
public class SimonGame extends GUIApplication {
	
	public static void main(String args[]){
		SimonGame sg = new SimonGame(800,600);
		Thread game = new Thread(sg);
		game.start();
	}
	public SimonGame(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initScreen() {
		SimonGameScreen sms = new SimonGameScreen(getWidth(),getHeight());
		setScreen(sms);

	}

}
