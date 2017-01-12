package partnerCodeHerePlease;
import simonAlex.ButtonInterfaceSimon;
import simonAlex.MoveInterface;

/**
 * Created by dav1d on 1/12/17.
 */
public class Move implements MoveInterface{
    private Button b; // button
    @Override
    public ButtonInterfaceSimon getButton() {
        return b;
    }
}
