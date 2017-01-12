package partnerCodeHerePlease;
import simonAlex.ButtonInterfaceSimon;
import simonAlex.MoveInterface;

/**
 * Created by dav1d on 1/12/17.
 */
public class Move implements MoveInterface{
    private ButtonInterfaceSimon b; // button
    public Move(ButtonInterfaceSimon b){
    	this.b = b;
    }
    
    @Override
    public ButtonInterfaceSimon getButton() {
        return b;
    }
}
