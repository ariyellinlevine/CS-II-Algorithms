package Astronamy;

public class Particle {
    double mass;

    double x = 0, y = 0;
    double xVel = 0, yVel = 0;

    String img;

    static String extension = "Astronamy/nbody/";

    public Particle(double x, double y, double xVel, double yVel, double mass, String img) {
        this.x = x;
        this.y = y;
        this.xVel = xVel;
        this.yVel = yVel;
        this.mass = mass;
        this.img = img;
    }

    public String toString() {
        return String.format("X: %d; Y: %d; xVel: %d; yVel: %d; Mass: %s; Img: %s", x, y, xVel, yVel, mass, img);
    }

}
