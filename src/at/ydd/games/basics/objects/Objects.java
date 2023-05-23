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

    private enum DirectionCir {UP, DOWN}

    private DirectionCir directionCir = DirectionCir.DOWN;

    public Objects(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.xRec = 100;
        this.yRec = 100;
        this.xel = 50;
        this.yel = 5;
        this.xcir = 10;
        this.ycir = 10;
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
            if (this.xel > 700) {
                directionEl = DirectionEl.LEFT;
            }
        } else if (directionEl == DirectionEl.LEFT) {
            this.xel -= (float) delta / this.speed;
            if (this.xel < 100) {
                directionEl = DirectionEl.RIGHT;
            }
        }


        if (directionCir == DirectionCir.DOWN) {
            this.ycir += (float) delta / this.speed;
            if (this.ycir > 500) {
                directionCir = DirectionCir.UP;
            }
        } else if (directionCir == DirectionCir.UP) {
            this.ycir -= (float) delta / this.speed;
            if (this.ycir < 10) {
                directionCir = DirectionCir.DOWN;
            }
        }
    }


    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.xRec, this.yRec, 100, 100);
        graphics.drawOval(this.xel, this.yel, 80, 20);
        graphics.drawOval(this.xcir, this.ycir, 70, 70);
        graphics.drawString("Hello you!", 40, 40);
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
