/*
*  AUTHOR - DAVID MEDINA
*  NOTE - There were many missing parts in the gui jar that caused countless errors. I tried going back to decompile
*  and edit the files, but i couldn't. Some classes were incomplete(missing essential methods) !!!!
*
*
*
* */

package simonAlex;

import java.awt.Color;
import java.util.ArrayList;

import guis.components.Action;
import guis.components.ClickableScreen;
import guis.components.TextLabel;
import guis.components.Visible;
import partnerCodeHerePlease.Button;
import partnerCodeHerePlease.Move;
import partnerCodeHerePlease.Progress;


public class SimonGameScreen extends ClickableScreen implements Runnable {
	private ArrayList<MoveInterface> moves;
	private TextLabel label;
	private ButtonInterfaceSimon[] buttons;
	private ProgressInterface progress;
	private int roundNumber;
	private	boolean acceptingInput;
	private int sequenceIndex;
	private	int lastSelectedButton;
	public SimonGameScreen(int width, int height) {
		
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		// TODO Auto-generated method stub
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		moves = new ArrayList<MoveInterface>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);

	}

	private MoveInterface randomMove() {
		int select = (int) (Math.random()*buttons.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*buttons.length);
		}
		lastSelectedButton = select;
		return new Move(buttons[select]);
		
		
		
	}
	
	private MoveInterface getMove(ButtonInterfaceSimon b) {
		// TODO Auto-generated method stub
		return new Move(b);
	}

	/**
	Placeholder until partner finishes implementation of simonAlex.ProgressInterface
	*/
	private ProgressInterface getProgress() {
		// TODO Auto-generated method stub
		return new Progress();
	}

	private void addButtons() {
		// TODO Auto-generated method stub
		int numberOfButtons = 4;
		Color[] colors = {Color.blue,Color.green,Color.yellow,Color.red};
		buttons = new ButtonInterfaceSimon[numberOfButtons]; // initialize array.
		for(int i = 0; i < buttons.length; i++){
			// In order to set the correct x/y coordinates, I had to use the constructor.
			// since that was the only way I could access the x and y coordinates.
			// because setX and setY were not included in the Visible interface.
			System.out.println("color: " + colors[i]);
			ButtonInterfaceSimon b = new Button((i + 1) * 150, 400 ,50, 50, colors[i]);//getAButton(colors[i]);
			b.setColor(colors[i]); // set color.
			System.out.println("Button has been made i: " + i);

			// I can't use the setter for x/y coordinates, since the Visible interface doesn't have them.
			//b.setX(800/2+100*(int)Math.cos(Math.PI/3*(i))); CANT USE :(
			//b.setY(600/2+100*(int)Math.sin(Math.PI/3*(i))); CANT USE :(
			b.setAction(new Action(){
				public void act(){
					Thread blink = new Thread(new Runnable(){

						public void run(){
							System.out.println("RUNING METHOD");
							b.highlight();
							
							try {
								Thread.sleep(800);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							b.dim();
						
						}
						
					});
					blink.start();
					System.out.println("Accepting: " + acceptingInput);
					if(acceptingInput){
						//if the user's button matches sequence
						if(b==moves.get(sequenceIndex).getButton())
							sequenceIndex++;
						else{
							progress.gameOver();
							return;
						}	
					}
					if(moves.size()==sequenceIndex){
						System.out.println("size: " + moves.size() + ", sIdx: " + sequenceIndex);
						Thread nextRound = new Thread(SimonGameScreen.this);
						nextRound.start();
						
					}
				}

				
			});
			System.out.println("DIMMMM");
			b.dim();
			viewObjects.add(b); // add components to vector.
			buttons[i] = b; // add button to buttons array.
		}
	}
	private ButtonInterfaceSimon getAButton(Color c) {
		// TODO Auto-generated method stub
		return new Button(100, 100, 100, 100, c);
	}

	@Override
	public void run() {
		label.setText("");
		System.out.println("NEW ROUND");
		nextRound();
		
	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;
		moves.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceSize(moves.size());
		changeText("Simon's turn!");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput=true;
		sequenceIndex=0;
		
	}

	private void playSequence() {
		ButtonInterfaceSimon b=null;
		for(int i=0; i<moves.size();i++){
			if(b!=null) b.dim();
			
			b=moves.get(i).getButton();
			b.highlight();
			int sleepTime=1000*(int)Math.exp(roundNumber);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
		
	}

	private void changeText(String s) {
		// TODO Auto-generated method stub
		label.setText(s);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
