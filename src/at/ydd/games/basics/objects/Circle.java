package at.ydd.games.basics.objects;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle implements Actor{
    private int x,y;
    private int diameter;
    private float speed;

    private enum Direction {RIGHT, DOWN, LEFT, UP}

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(800);
        this.speed = random.nextInt(40)+10;
        this.diameter = random.nextInt(20)+20;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(int delta) {
        this.y += (float)delta/this.speed;
        if(this.y>600){
            this.y = 0;
        }
    }
}
