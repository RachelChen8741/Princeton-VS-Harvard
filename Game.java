// client class that creates the game board, allowing two players to control the
// tiger and pilgrim objects, with key presses that corresponds to move, aim,
// and shoot, checking if bullet hits the opponent and increasing score for
// player on scoreboard, ending the game when one of the players reach 10 points
// and announcing the winner and score of both players.
 
import java.awt.Font;
 
public class Game {
    public static void main(String[] args) {
        // initialize and create tiger and pilgrim at given position and angle
        Princeton tiger = new Princeton(-8.3, 0, 0);
        Harvard pilgrim = new Harvard(8.5, -1, 0);
        StdDraw.setXscale(-10, 10); // sets game board to 20 x 20 dimensions
        StdDraw.setYscale(-10, 10);
        StdDraw.enableDoubleBuffering(); // enables double buffering
        StdAudio.play("Gamemusic.wav"); // plays music on standard audio
        String keyboardString = "wasdqijklo"; // create string for key inputs
        // initialize array of bullets for tiger and pilgrim, with limit 5000
        Bullet[] shootingtiger = new Bullet[5000]; 
        Bullet[] shootingpilgrim = new Bullet[5000]; 
        int counttiger = 0; // bullet count for tiger
        int countpilgrim = 0; // bullet count for tiger
        int scoretiger = 0; // score count for Princeton tiger
        int scorepilgrim = 0; //  score count for Harvard pilgrim
        while (true) {
            // check if the user has played a key; if so, process it (Guitarhero)
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped(); // key the user played
                int a = keyboardString.indexOf(key);
                // use switch if key in allowed key input is pressed (booksite)
                if (a != -1) {
                    switch (a) {
                        case 0: // if key is w, move tiger up by 0.2
                            tiger.move(1);
                            break;
                        case 1: // if key is a, rotate tiger by 10 degrees ccw
                            tiger.aim(10);
                            break;
                        case 2: // if key is s, move tiger down by 0.2
                            tiger.move(-1);
                            break;
                        case 3:  // if key is d, rotate tiger by 10 degrees cw
                            tiger.aim(-10);
                            break;
                        case 4: // if key is q, tiger shoots a bullet
                            shootingtiger[counttiger] = tiger.shoot();
                            counttiger++; // increment bullet count
                            break;
                        case 5: // if key is i, move pilgrim up by 0.2
                            pilgrim.move(1);
                            break;
                        case 6: // if key is j, rotate pilgrim by 10 degrees ccw
                            pilgrim.aim(10);
                            break;
                        case 7: // if key is k, move pilgrim down by 0.2
                            pilgrim.move(-1);
                            break;
                        case 8: // if key is l, rotate pilgrim 10 degrees cw
                            pilgrim.aim(-10);
                            break;
                        case 9: // if key is o, pilgrim shoots a bullet
                            shootingpilgrim[countpilgrim] = pilgrim.shoot();
                            countpilgrim++; // increment bullet count
                    }
                }
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "IMG_4324.jpeg", 30, 20); // sets background
            for (int i = 0; i < counttiger; i++) {
                shootingtiger[i].movetiger(); // moves bullets for tiger
                StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE); // set bullet color
                shootingtiger[i].draw(); // show bullet the tiger shoots
                // compute distance between bullet and pilgrim
                double dx = shootingtiger[i].getX() - pilgrim.getX();
                double dy = shootingtiger[i].getY() - pilgrim.getY();
                double distance = Math.sqrt((dx * dx) + (dy * dy));
                // if distance is within 1.5 units, increment count, and make
                // bullet disappear out of bounds
                if (distance <= 1.5) {
                    scoretiger++;
                    shootingtiger[i].setX(15);
                }
                // make bullets disappear out of bounds if tiger missed pilgrim
                if (shootingtiger[i].getX() >= 10) {
                    shootingtiger[i].setX(15);
                    shootingtiger[i].draw();
                }
                if (shootingtiger[i].getY() >= 10 ||
                        shootingtiger[i].getY() <= -10) {
                    shootingtiger[i].setY(-15);
                    shootingtiger[i].draw();
                }
            }
            for (int i = 0; i < countpilgrim; i++) {
                shootingpilgrim[i].movepilgrim(); // moves bullets for pilgrim
                StdDraw.setPenColor(StdDraw.BOOK_RED); // set bullet color
                shootingpilgrim[i].draw(); // show bullet the pilgrim shot
                // compute distance between bullet and Princeton tiger
                double dx = shootingpilgrim[i].getX() - tiger.getX();
                double dy = shootingpilgrim[i].getY() - tiger.getY();
                double distance = Math.sqrt((dx * dx) + (dy * dy));
                // if distance is within 1.5 units, increment count, and make
                // bullet disappear out of bounds
                if (distance <= 1.5) {
                    scorepilgrim++;
                    shootingpilgrim[i].setX(-15);
                }
                // make bullets disappear out of bounds if pilgrim missed tiger
                if (shootingpilgrim[i].getX() <= -10) {
                    shootingpilgrim[i].setX(-15);
                    shootingpilgrim[i].draw();
                }
                if (shootingpilgrim[i].getY() >= 10 ||
                        shootingpilgrim[i].getY() <= -10) {
                    shootingpilgrim[i].setY(-15);
                    shootingpilgrim[i].draw();
                }
            }
            StdDraw.setPenColor(StdDraw.BLACK);
            Font font = new Font("SERIF", Font.BOLD, 20); // creates new font
            StdDraw.setFont(font); // sets the font to the new font
            // display score for Princeton tiger and Harvard pilgrim
            StdDraw.text(-7, 7.3, "Princeton/ " + Integer.toString(scoretiger));
            StdDraw.text(7, 7.5, "Harvard/ " + Integer.toString(scorepilgrim));
            tiger.draw(); // draws Princeton tiger
            pilgrim.draw(); // draws Harvard pilgrim
            StdDraw.show();
            StdDraw.pause(20); // controls animation speed
            Font winner = new Font("SERIF", Font.BOLD, 50); // font for winner
            Font score = new Font("SERIF", Font.ITALIC, 15); // font for score
            // set celebration background for winner, display Princeton as
            // winner and display score of both players
            if (scoretiger == 10) {
                StdDraw.clear();
                StdDraw.picture(0, 3, "Celebration.png");
                StdDraw.setFont(winner);
                StdDraw.text(0, 1, "Princeton wins!");
                StdDraw.setFont(score);
                StdDraw.text(-2, -1, "Score: Princeton - 10");
                StdDraw.text(2.4, -1, "Harvard - " + scorepilgrim);
                StdDraw.show();
                StdDraw.pause(Integer.MAX_VALUE);
            }
            // set celebration background for winner, display Harvard as
            // winner and display score of both players
            else if (scorepilgrim == 10) {
                StdDraw.clear();
                StdDraw.picture(0, 3, "Celebration.png");
                StdDraw.setFont(winner);
                StdDraw.text(0, 1, "Harvard wins!");
                StdDraw.setFont(score);
                StdDraw.text(-2, -1, "Score: Harvard - 10");
                StdDraw.text(2.4, -1, "Princeton - " + scoretiger);
                StdDraw.show();
                StdDraw.pause(Integer.MAX_VALUE);
            }
        }
    }
}