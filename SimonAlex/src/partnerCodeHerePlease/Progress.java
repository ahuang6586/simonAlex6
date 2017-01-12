package partnerCodeHerePlease;

import guis.components.Component;
import simonAlex.ProgressInterface;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by dav1d on 1/12/17.
 */
public class Progress extends Component implements ProgressInterface {
    private BufferedImage image;
    private int sequenceSize, round;

    public Progress(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    @Override
    public void gameOver() {

    }

    @Override
    public void setRound(int roundNumber) {
        round = roundNumber;
    }

    @Override
    public void setSequenceSize(int size) {
        sequenceSize = size;
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getWidth() {
        return super.getWidth();
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public boolean isAnimated() {
        return false;
    }

    @Override
    public void update() {

    }

    @Override
    public void update(Graphics2D graphics2D) {

    }
}
