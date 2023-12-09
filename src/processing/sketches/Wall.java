package processing.sketches;

import math.Vector;
import processing.core.PApplet;

import static processing.core.PApplet.abs;

public class Wall {
    private final static PApplet p = Main.applet;

    Vector origin;
    Vector tip;

    public Wall(Vector origin, Vector tip) {
        this.origin = origin;
        this.tip = tip;
    }

    public Wall(float x1, float y1, float x2, float y2) {
        this.origin = new Vector(x1, y1);
        this.tip = new Vector(x2, y2);
    }

    public Vector getNormal() {
        Vector dVector = tip.minus(origin);
        return new Vector(-dVector.getY(), dVector.getX());
    }

    public Vector getCenter() {
        Vector dVector = tip.minus(origin);
        return origin.plus(dVector.times(0.5f));
    }

    private float getIllumination(Vector lightVector) {
        float size = new Vector(p.width/2, p.height/2).magnitude();
        float illuminance = (size - lightVector.magnitude()) / size;
        return p.max(0, -lightVector.dot(getNormal()) * illuminance);
    }

    public void drawSelf(Light light) {
        Vector lightVector = getCenter().minus(light.getPosition());
        p.strokeWeight(3);
        p.stroke(0, 0, getIllumination(lightVector)*255);
        p.line(origin.getX(), origin.getY(), tip.getX(), tip.getY());
    }
}
