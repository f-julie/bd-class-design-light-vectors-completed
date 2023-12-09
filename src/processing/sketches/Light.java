package processing.sketches;

import math.Vector;
import processing.core.PApplet;

public class Light {
    private static final PApplet p = Main.applet;

    private Vector position;

    public Light(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void drawSelf() {
        p.noStroke();
        p.fill(150);
        p.rect(position.getX() - 10, position.getY() + 10, 20, 20);
        p.fill(255);
        p.ellipse(position.getX(), position.getY(), 30, 30);
        p.stroke(0);
        p.strokeWeight(1);
        p.line(position.getX(), position.getY()+15, position.getX()-5, position.getY());
        p.line(position.getX(), position.getY()+15, position.getX()+5, position.getY());
        p.line(position.getX()-10, position.getY()+25, position.getX()+10, position.getY() + 25);
        p.line(position.getX()-10, position.getY()+20, position.getX()+10, position.getY() + 20);
    }
}
