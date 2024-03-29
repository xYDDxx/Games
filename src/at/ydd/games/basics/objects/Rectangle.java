package at.ydd.games.basics.objects;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor{
    private int x;
    private int y;
    private float speed;

    private enum Direction {RIGHT, DOWN, LEFT, UP}

    public Rectangle(int x, int y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 20, 20);
    }

    public void update(int delta) {
        this.x += (float)delta/this.speed;
        if(this.x>800){
            this.x = 0;
        }
    }

}
