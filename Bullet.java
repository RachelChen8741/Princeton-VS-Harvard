// create, move, and draw bullet for Princeton tiger and Harvard pilgrim
 
public class Bullet {
    // initialize instance variables
    private double x; // x-coordinate of bullet
    private double y; // y-coordinate of bullet
    private double angle; // angle of bullet
    private final double velocity; // distance that the bullet travels
 
    // creates bullet with x, y coordinates and angle
    public Bullet(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.velocity = 0.1;
    }
 
    // moves bullets for the Princeton tiger, travelling horizontally from left
    // to right
    public void movetiger() { 
        // compute distance of movement in x and y direction according to given
        // angle (calculation based on NBody)
        double xVelocity = this.velocity * Math.cos(Math.toRadians(angle));
        double yVelocity = this.velocity * Math.sin(Math.toRadians(angle));
 
        // if bullet is within boundary of game board, move bullet by
        // updating its x and y coordinate
        if (y < 10 && y > -10 && x < 10 && x > -10) {
            x = x + xVelocity;
            y = y + yVelocity;
        }
    }
 
    // moves bullets for the Harvard pilgrim, travelling horizontally from right
    // to left
    public void movepilgrim() {
        // compute distance of movement in x and y direction according to given
        // angle
        double xVelocity = this.velocity * Math.cos(Math.toRadians(angle));
        double yVelocity = this.velocity * Math.sin(Math.toRadians(angle));
 
        // if bullet is within boundary of game board, move bullet by
        // updating its x and y coordinate
        if (y < 10 && y > -10 && x < 10 && x > -10) {
            x = x - xVelocity;
            y = y - yVelocity;
        }
    }
 
    // draw bullet to standard draw as a circle with radius 0.15
    public void draw() {
        StdDraw.filledCircle(x, y, 0.15);
    }
 
    // returns x-coordinate of bullet
    public double getX() {
        return x;
    }
 
    // returns y-coordinate of bullet
    public double getY() {
        return y;
    }
 
    // set x-coordinate of bullet to tiger's or pilgrim's x coordinate
    public void setX(double x) {
        this.x = x;
    }
 
    // set y-coordinate of bullet to tigers' or pilgrims' y coordinate
    public void setY(double y) {
        this.y = y;
    }
 
    // set angle of bullet to tiger's or pilgrim's angle
    public void setAngle(double angle) {
        this.angle = angle;
    }
 
    // test this class by directly calling all constructors and instant methods
    public static void main(String[] args) {
        // set game board to be 20 x 20
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
 
        // enable double buffering
        StdDraw.enableDoubleBuffering();
 
        // create new bullet with position (-9.5, 0) and angle 0
        Bullet b = new Bullet(-9.5, 0, 0);
 
        // call getX method and print bullet's x-coordinate
        StdOut.println(b.getX());
 
        // call getY method and print bullet's y-coordinate
        StdOut.println(b.getY());
 
        // move the bullet horizontally moving straight from left to right
        while (b.getX() < 10) {
            b.movetiger();
            StdDraw.clear();
            b.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
 
        // set new x, y coordinate and angle of bullet
        b.setX(9.5);
        b.setY(5);
        b.setAngle(30);
 
        // move the bullet horizontally at angle of 30 counterclockwise from
        // right to left
        while (b.getX() < 10) {
            b.movepilgrim();
            StdDraw.clear();
            b.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
 