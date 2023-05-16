package at.ydd.games.basics.rectangles;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    private float xRec;
    private float yRec;
    private float speed;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xRec = 100;
        this.speed = 2.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.xRec += (float)delta/this.speed;
        this.yRec += delta;


        if (this.xRec>700){
            this.xRec=0;
            this.yRec=0;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRec, this.yRec, 100, 100);
        graphics.drawString("Hello you!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
