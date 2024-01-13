// draws and displays the Princeton tiger player, and enables player to control
// the tigers' movement, allowing tiger to move up and down, aim at a specific
// angle, and shoot a bullet.
 
public class Princeton {
    // initialize instance variables
    private final double x; // x-coordinate of Princeton tiger
    private double y; // y-coordinate of Princeton tiger
    private double angle; // shooting angle of Princeton tiger
    private double yVelocity; // distance that Princeton tiger moves up or down
    private Stack<Bullet> bullets; // stores bullets for Princeton tiger
 
    // creates Princeton tiger with x, y coordinates and angle
    public Princeton(double x, double y, double angle) {
        // set up initial x, y coordinate, angle, and distance in vertical
        // movement for Princeton tiger
        this.x = x;
        this.y = y;
        this.angle = angle;
        yVelocity = 0.2;
 
        // create storage of bullets for Princeton tiger, assigning it a
        // limit of 5000 bullets
        bullets = new Stack<Bullet>();
        for (int i = 0; i < 5000; i++) {
            Bullet b = new Bullet(x, y, 0);
            bullets.push(b);
        }
    }
 
    // returns x-coordinate of Princeton tiger
    public double getX() {
        return x;
    }
 
    // returns y-coordinate of Princeton tiger
    public double getY() {
        return y;
    }
 
    // returns shooting angle of Princeton tiger
    public double getAngle() {
        return angle;
    }
 
    // draws the Princeton tiger using standard draw
    public void draw() {
        // adjust angle of Princeton tiger drawing to be equivalent to that of
        // the angle given
        double picangle = getAngle();
 
        // move picture down by 0.36 so that bullets will appear out of
        // tiger's gun
        StdDraw.picture(x, y - 0.36, "Tiger.png", 3.5, 2.7, picangle);
    }
 
    // moves Princeton tiger up or down
    public void move(int direction1) {
        // returns message if Princeton tiger moves past boundary
        if (y + direction1 * yVelocity > 10 || y + direction1 * yVelocity < -10) {
            StdOut.println("Ouch! Hit the wall!");
            y = -9.99; // move tiger to just within bottom boundary so bullet
            // can still shoot out
        }
 
        // if Princeton tiger is within boundary, update y coordinate, moving it
        // up or down by 0.2
        else {
            y = y + direction1 * yVelocity;
        }
    }
 
    // rotates Princeton tiger clockwise or counterclockwise for shooting aim
    public void aim(double direction) {
        // returns message if Princeton tiger shoots behind them instead of in
        // front at the target Harvard pilgrim
        if (angle + direction > 90 || angle + direction < -90) {
            StdOut.println("Whoops! Improve your aim :)");
        }
 
        // if Princeton tiger correctly aims in front at target Harvard pilgrim,
        // update angle by 10 degrees clockwise or counterclockwise
        else {
            angle = angle + direction;
        }
    }
 
    // if bullet storage not empty, returns a bullet with position and angle
    // equal to that of Princeton tiger's coordinates and shooting angle
    public Bullet shoot() {
        // if bullet limit of 5000 is reached, throw exception message
        if (bullets.isEmpty()) {
            throw new RuntimeException("To think someone would use up 5000" 
                                               + " bullets and still not hit " 
                                               + " ten times. Do better <3"); 
        }
        // if bullet storage is within limits, return bullet with position and
        // angle equal to that of Princeton tiger's coordinates and shooting
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
 
        // create Princeton tiger with starting position at (-8.3, 0) and
        // with angle of 0 degrees
        Princeton tiger = new Princeton(-8.3, 0, 0);
 
        // call getX method and print tiger's x-coordinate
        StdOut.println(tiger.getX());
 
        // call getY method and print tiger's y-coordinate
        StdOut.println(tiger.getY());
 
        // call getAngle method and print tiger's angle
        StdOut.println(tiger.getAngle());
 
        StdDraw.enableDoubleBuffering();
 
        // creates array of bullets that stores the maximum amount of bullets
        Bullet[] shooting = new Bullet[5000];
 
        // initialize bullet count to 0
        int count = 0;
 
        // tiger shoots out a bullet in straight line and increment count
        shooting[count] = tiger.shoot();
        count++;
 
        boolean flag1 = false;
        boolean flag2 = false;
        while (true) {
            StdDraw.clear();
 
            // move all the bullets that are shot and draw them
            for (int i = 0; i < count; i++) {
                shooting[i].movetiger();
                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
                shooting[i].draw();
            }
 
            // move tiger 2 units down, rotate tiger's aim by 10 degrees
            // counterclockwise, and shoot out a bullet
            if (shooting[0].getX() > 0 && !flag1) {
                tiger.move(-10); // call move instance method
                tiger.aim(10); // call aim instance method
                shooting[count] = tiger.shoot(); // call shoot instance method
                count++;
                flag1 = true;
            }
 
            // hit the wall after previous bullet's x-coordinate is greater than
            // 3, then rotate aim by large number to test boundary case, and
            // shoot third bullet
            if (shooting[0].getX() > 3 && flag1 && !flag2) {
                tiger.move(-50); // test hit the wall corner case
                tiger.aim(180); // test boundary case
                shooting[count] = tiger.shoot(); // call shoot instance method
                count++;
                flag2 = true;
            }
 
            // draws the Princeton tiger to standard draw
            tiger.draw();
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}