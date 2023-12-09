package processing.sketches;

import math.Vector;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {
    public static PApplet applet;

    List<Wall> walls;
    Light light;

    public void settings() {
        applet = this;
        size(600, 600);
    }

    public void setup() {
        createWalls();
        light = new Light(new Vector(width/2, height/2));
        colorMode(HSB);
        noStroke();
        noCursor();
    }

    public void draw() {
        background(0);

        light.setPosition(new Vector(mouseX, mouseY));
        light.drawSelf();
        for (Wall wall : walls) {
            wall.drawSelf(light);
        }
    }

    private void createWalls() {
        walls = new ArrayList<>();
        //Inner Ring
        walls.add(new Wall(250, 200, 200, 250));
        walls.add(new Wall(200, 250, 200, 350));
        walls.add(new Wall(200, 350, 250, 400));
        walls.add(new Wall(250, 400, 350, 400));
        walls.add(new Wall(350, 400, 400, 350));
        walls.add(new Wall(400, 350, 400, 250));
        walls.add(new Wall(400, 250, 350, 200));
        walls.add(new Wall(350, 200, 250, 200));

        //Outter Ring
        walls.add(new Wall(50, 150, 150, 50));
        walls.add(new Wall(50, 450, 50, 150));
        walls.add(new Wall(150, 550, 50, 450));
        walls.add(new Wall(450, 550, 150, 550));
        walls.add(new Wall(550, 450, 450, 550));
        walls.add(new Wall(550, 150, 550, 450));
        walls.add(new Wall(450, 50, 550, 150));
        walls.add(new Wall(150, 50, 450, 50));
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
