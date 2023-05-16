package at.ydd.games.basics.objects;

import org.newdawn.slick.*;

public class Objects extends BasicGame {
    private float xRec;
    private float yRec;
    private float speed;
    private float xcir;
    private float ycir;
    private float xel;
    private float yel;

    private enum DirectionRec {RIGHT, DOWN, LEFT, UP}

    private DirectionRec directionRec = DirectionRec.RIGHT;

    private enum DirectionEl {RIGHT, LEFT}

    private DirectionEl directionEl = DirectionEl.RIGHT;

    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xRec = 100;
        this.yRec = 100;
        this.xel = 50;
        this.yel = 5;
        this.speed = 3.0f;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        if (directionRec == DirectionRec.RIGHT) {
            this.xRec += (float) delta / this.speed;
            if (this.xRec > 600) {
                this.directionRec = DirectionRec.DOWN;
            }
        } else if (directionRec == DirectionRec.DOWN) {
            this.yRec += (float) delta / this.speed;
            if (this.yRec > 400) {
                directionRec = DirectionRec.LEFT;
            }
        } else if (directionRec == DirectionRec.LEFT) {
            this.xRec -= (float) delta / this.speed;
            if (xRec < 100) {
                this.directionRec = DirectionRec.UP;
            }
        } else if (directionRec == DirectionRec.UP) {
            this.yRec -= (float) delta / this.speed;
            if (this.yRec < 100) {
                this.directionRec = DirectionRec.RIGHT;
            }
        }

        if (directionEl == DirectionEl.RIGHT) {
            this.xel += (float) delta / this.speed;
            System.out.println("right");
            if (this.xel > 700) {
                directionEl = DirectionEl.LEFT;
            }
            if (directionEl == DirectionEl.LEFT) {
                System.out.println("left");
                this.xel -= (float) delta / this.speed;
                System.out.println("left");
                if (this.xel < 100) {
                    directionEl = DirectionEl.RIGHT;
                }
            }
        }


    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRec, this.yRec, 100, 100);
        graphics.drawOval(this.xel, this.yel, 80, 20);
        graphics.drawString("Hello you!", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Objects("Objects"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
