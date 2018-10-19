package at.htl.robot.gui;

import static at.htl.robot.model.Direction.EAST;
import static at.htl.robot.model.Direction.NORTH;
import static at.htl.robot.model.Direction.SOUTH;
import static at.htl.robot.model.Direction.WEST;
import at.htl.robot.model.Robot;
import processing.core.PApplet;
import static processing.core.PApplet.println;

public class Main extends PApplet {

    // Hier die Member-Attribute eintragen
    int upperM = 80;
    int leftM = 80;
    int cell = 60;
    String mode = "R";
    Robot robot = new Robot(0, 0);

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);

    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(200); //https://processing.org/tutorials/color/

    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {
        deleteAll();
        for (int i = 0; i < 11; i++) {
            line(leftM, upperM + (cell * i), (10 * cell), upperM + (cell * i));
        }
        for (int j = 0; j < 10; j++) {
            line(leftM + (cell * j), upperM, leftM + (cell * j), upperM + (10 * cell));
        }

        drawRobot(robot);
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm
     * gezeichnet wird Die Angabe zu Position des Roboters am Spielfeld erhalten
     * Sie aus dem Roboter-Objekt, welches als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {

        if (mode.equals("R")) {
            if (robot.getX() == 9) {
                robot.setX(8);
            }

            if (robot.getX() == -1) {
                robot.setX(0);
            }

            if (robot.getY() == 10) {
                robot.setY(9);
            }

            if (robot.getY() == -1) {
                robot.setY(0);
            }
        } else if (mode.equals("T")) {
            if (robot.getX() == 9) {
                robot.setX(0);
            }

            if (robot.getX() == -1) {
                robot.setX(8);
            }

            if (robot.getY() == 10) {
                robot.setY(0);
            }

            if (robot.getY() == -1) {
                robot.setY(9);
            }
        }

        fill(255, 255, 255);
        ellipse(leftM + (cell / 2) + (cell * robot.getX()), upperM + (cell / 2) + (cell * robot.getY()), (int) (cell * 0.8), (int) (cell * 0.8));

        fill(0, 255, 0);

        switch (robot.getDirection()) {
            case NORTH:
                text(mode, leftM + (int) (cell / 2 * 0.9) + (cell * robot.getX()), upperM + (int) (cell / 2 * 0.65) + (cell * robot.getY()));
                break;

            case EAST:
                text(mode, leftM + (int) (cell / 2 * 1.4) + (cell * robot.getX()), upperM + (int) (cell / 2 * 1.15) + (cell * robot.getY()));
                break;

            case SOUTH:
                text(mode, leftM + (int) (cell / 2 * 0.9) + (cell * robot.getX()), upperM + (int) (cell / 2 * 1.7) + (cell * robot.getY()));
                break;

            case WEST:
                text(mode, leftM + (int) (cell / 2 * 0.35) + (cell * robot.getX()), upperM + (int) (cell / 2 * 1.15) + (cell * robot.getY()));
                break;
        }

    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(200);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if (key == 'f' || key == 'F') {
            robot.stepForward();

        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        } else if (key == 'm' || key == 'M') {
            if (robot.isMode() == false) {
                robot.setMode(true);
                mode = "T";
            } else if (robot.isMode()) {
                robot.setMode(false);
                mode = "R";
            }
        }

    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }
}
