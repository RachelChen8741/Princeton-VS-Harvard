// draws and displays the Harvard pilgrim player, and enables player to control
// the pilgrim's movement, allowing pilgrim to move up and down, aim at a specific
// angle, and shoot a bullet.
 
public class Harvard {
    // initialize instance variables
    private final double x; // x-coordinate of Harvard pilgrim
    private double y; // y-coordinate of Harvard pilgrim
    private double angle; // shooting angle of Harvard pilgrim
    private double yVelocity; // distance that Harvard pilgrim moves up or down
    private Stack<Bullet> bullets; // stores bullets for Harvard pilgrim
 
    // creates Harvard pilgrim with x, y coordinates and angle
    public Harvard(double x, double y, double angle) {
        // set up initial x, y coordinate, angle, and distance in vertical
        // movement for Harvard pilgrim
        this.x = x;
        this.y = y;
        this.angle = angle;
        yVelocity = 0.2;
 
        // create storage of bullets for Harvard pilgrim, assigning it a
        // limit of 5000 bullets
        bullets = new Stack<Bullet>();
        for (int i = 0; i < 5000; i++) {
            Bullet b = new Bullet(x, y, 0);
            bullets.push(b);
        }
    }
 
    // returns x-coordinate of Harvard pilgrim
    public double getX() {
        return x;
    }
 
    // returns y-coordinate of Harvard pilgrim
    public double getY() {
        return y;
    }
 
    // returns shooting angle of Harvard pilgrim
    public double getAngle() {
        return angle;
    }
 
    // draws the Harvard pilgrim using standard draw
    public void draw() {
        // adjust angle of Harvard pilgrim drawing to be equivalent to that of
        // the angle given
        double picangle = getAngle();
 
        // move picture up by 0.59 so that bullets will appear out of
        // pilgrim's gun
        StdDraw.picture(x, y + 0.59, "Harvard.png", 3, 3, picangle);
    }
 
    // moves Harvard pilgrim up or down
    public void move(int direction1) {
        // returns message if Harvard pilgrim moves past boundary
        if (y + direction1 * yVelocity > 10 || y + direction1 * yVelocity < -10) {
            StdOut.println("Ouch! Hit the wall!");
        }
 
        // if Harvard pilgrim is within boundary, update y coordinate, moving it
        // up or down by 0.2
        else {
            y = y + direction1 * yVelocity;
        }
    }
 
    // rotates Harvard pilgrim clockwise or counterclockwise for shooting aim
    public void aim(double direction) {
        // returns message if Harvard pilgrim shoots behind them instead of in
        // front at the target Princeton tiger
        if (angle + direction > 90 || angle + direction < -90) {
            StdOut.println("Whoops! Improve your aim :)");
        }
 
        // if Harvard pilgrim correctly aims in front at target Princeton tiger,
        // update angle by 10 degrees clockwise or counterclockwise
        else {
            angle = angle + direction;
        }
    }
 
    // if bullet storage not empty, returns a bullet with position and angle
    // equal to that of Harvard pilgrim's coordinates and shooting angle
    public Bullet shoot() {
        // if bullet limit of 5000 is reached, throw exception message
        if (bullets.isEmpty()) {
            throw new RuntimeException("To think someone would use up 5000"
                                               + " bullets and still not hit "
                                               + " ten times. Do better <3");
        }
        // if bullet storage is within limits, return bullet with position and
        // angle equal to that of Harvard pilgrim's coordinates and shooting
        // angle
        else {
            Bullet b = bullets.pop();
            b.setX(getX());
            b.setY(getY());
            b.setAngle(getAngle());
            return b;
        }
    }
 
    // test this class by directly calling all constructors and instant methods
    public static void main(String[] args) {
        // set game board to be 20 x 20
        StdDraw.setXscale(-10, 10);
        StdDraw.setYscale(-10, 10);
 
        // create Harvard pilgrim with starting position at (8.5, 0) and
        // with angle of 0 degrees
        Harvard pilgrim = new Harvard(8.5, 0, 0);
 
        // call getX method and print pilgrim's x-coordinate
        StdOut.println(pilgrim.getX());
 
        // call getY method and print pilgrim's y-coordinate
        StdOut.println(pilgrim.getY());
 
        // call getAngle method and print pilgrim's angle
        StdOut.println(pilgrim.getAngle());
 
        // enable double buffering
        StdDraw.enableDoubleBuffering();
 
        // creates array of bullets that stores the maximum amount of bullets
        Bullet[] shooting = new Bullet[5000];
 
        // initialize bullet count to 0
        int count = 0;
 
        // increment bullet count when pilgrim shoots out a bullet
        shooting[count] = pilgrim.shoot();
        count++;
 
        boolean flag = false;
        while (true) {
            StdDraw.clear();
 
            // shoot out a bullet in straight line and draw it
            for (int i = 0; i < count; i++) {
                shooting[i].movepilgrim();
                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                shooting[i].draw();
            }
 
            // move pilgrim 2 units down, rotate pilgrim's aim by 10 degrees
            // counterclockwise, and shoot out a bullet
            if (shooting[0].getX() < 0 && !flag) {
                pilgrim.move(-10); // call move instance method
                pilgrim.aim(10); // call aim instance method
                shooting[count] = pilgrim.shoot(); // call shoot instance method
                count++;
                flag = true;
            }
 
            // draws the Harvard pilgrim to standard draw
            pilgrim.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}