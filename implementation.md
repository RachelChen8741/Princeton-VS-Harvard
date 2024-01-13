COS126 Final Project: Implementation
Please complete the following questions and upload this implementation.md
file to the TigerFile assignment for the "Final Project Implementation".

Do not alter the formatting
(e.g. write your answer after the asterisks  FIELD NAME  or on the next
line after the header ### HEADER NAME). We have filled in a dummy response
for the first question in the first two sections as an example.

Basic Information
You may copy and paste your answers from questions 1-8 in the status update.

Name 1: Jingwen (Jenny) Jiang 
NetID 1: jj7782
Name 2 (include if pair project): Rachel Chen
NetID 2 (include if pair project): rc7210

Project preceptor name: Donna Gabai
Project title: "Princeton vs. Harvard"
CodePost link for proposal: https://codepost.io/code/566868
CodePost link for revised proposal (include if submitted):
CodePost link for status update: https://codepost.io/code/581978
Link to project video: https://www.loom.com/share/0d33316f03444e0c8a8c4ca9def30038
Number of hours to complete implementation: 30 hours
Required Questions
A. Describe your implemented project in a few sentences below.
Our final project brings the Princeton vs. Harvard rivalry into a 2 dimensional form of a game, in which two players are able to control either the Princeton tiger or Harvard pilgrim using the keys wasdq or ijklo to move, aim, and shoot at the opponent; only the player with the best skills would hit the opponent 10 times first and achieve victory (and bragging rights of course). The players are able to move up or down vertically, rotate to aim, and shoot bullets simply by pressing the allowed keys which are recieved as input. We have a total of four .java files, two of which are used for object classes, creating the Princeton tiger and the Harvard Pilgrim, one of which creates the bullet, and the last one acts a client class, rendering the actual gameboard, including the scores, collision detector, and result screen. When the bullet shot by one of the players is within a certain range (a distance of 1.5), the score for that player increments by 1, and this is applied for both Princeton and Harvard until one of them reaches 10. When that occurs, the game ends, showing the result screen that announces the winner as well as the score. 

B. Describe your three features.
Be specific in your description of each feature.
In particular, specify where they are implemented
(e.g. .java file name, starting and ending line numbers, method names, etc.).

Our first feature is a two player game, in which one of the players controls the Princeton tiger using the keys wasdq, whereas the other player controls the Harvard pilgrim with the keys ijklo, where the keys correspond to moving up and down, rotating aim clockwise and counterclockwise, and shooting out a bullet. This feature was implemented in the Game.java file, which creates the two players in lines 12-13, and in lines 27 - 78, we used switch cases to assign each key press with the corresponding movements. 
Our second feature was to have each player shoot bullets at each other, detecting if the bullet hits the opponent or not (the player could shoot by using the key q for Princeton or key o for Harvard). Then if the bullet does hit the target, we would increment the score for that player, and if it doesn’t, we would have the bullets disappear out of bounds from the gameboard. This feature was implemented in the Bullet.java file, which creates, moves, and draws the bullets using the instance methods movetiger() for bullets shot by the tiger, which moves from left to right of the game board and movepilgrim() for bullets shot by the pilgrim, which moves in the opposite direction from right to left of the game board. In Game.java, the collision detector was implemented in lines 81 - 120 by computing distance between bullet and target, seeing if they are within 1.5 units in distance. If within distance, score for each player is incremented with the code scoretiger++ or scorepilgrim++. 
Our final feature was to keep and display the score on the gameboard and end the game with a message announcing the winner and corresponding score for each player once one of the players reaches 10 points. This feature is implemented in Game.java from lines 121 - 160, which clears the previous game board and displays a new screen with a celebration background and text with the score and winner using standard draw. 
C. Describe in detail how to compile and run your program.
Include a few example run commands and the expected results of running your program.
For non-textual outputs (e.g. graphical or auditory), feel free to describe in 
words what the output should be or reference output files (e.g. images, audio files)
of the expected output.

To compile, use the command "javac-introcs Game.java" into terminal, and then type "java-intros Game" to run the program. Because our program takes in keyboard presses, example run command would be pressing the key "w" on the keyboard, which would move the Princeton tiger up by 0.2 each time the "w" key is pressed on the actual gameboard. In the same regard, pressing the key "o" would cause the Harvard pilgrim to shoot bullets on the gameboard each time the key is pressed. The program should effectively take in the keyboard presses and show the corresponding movement, as well as keep score for both players in terms of how many times they were able to accurately hit the opponent. Our program will stop and display the result screen when one of the players reaches 10 first, which announces the winner as well as the scores of both players.

D. Describe how your program accepts user input
Mention the line number(s) at which your program accepts user input.

Our program receives keyboard presses as input, which is accepted in lines 27-78 of Game.java. The accepted keys are: w, a, s, d, q, i, j, k, l, and o. Any other key would have have no result.

E. Describe how your program produces output based on user input
Mention the line number(s) at which your program produces output.

Our game outputs a standard draw canvas in the form of a gameboard with dimensions 20 by 20 and displays 2 players – a Princeton tiger and Harvard pilgrim, which was created on lines 13 - 16 in Game.java, by calling the Princeton.java and Harvard.java classes. The tiger and pilgrim's movements (up and down, rotate clockwise and counterclockwise and shooting bullets) correspond to key presses (games' input), which was implemented using switch cases on lines 27 - 78 in Game.java. Moving and drawing the tiger itself was implemented in the Princeton.java class with the draw() method on lines 47 - 55. Similarly, moving and drawing the pilgrim itself was implemented in the Harvard.java class with the draw() method on lines 47 - 55. Drawing and displaying the bullet's movement on the game board was implemented in the Bullet.java class with the draw() method on lines 51 - 53. Finally, the game halts once a player reaches 10 points, and a new screen is displayed with a celebration background and text with the score and winner, which was implemented using standard draw on lines 121 - 160 of Game.java. 

F. Describe the data structure your program uses
Also describe how it supports your program's functionality.
Include the variable name and the line number(s) at which it is declared
and initialized).

Array of bullets for tiger and pilgrim, with a maximum limit of 5000 bullets for each player. These arrays were initiated in lines 21-22 in Game.java. 

Stack of bullets for tiger and pilgrim, initiated as instance variable in line 11 of Princeton.java and Harvard.java. Then in lines 24 - 27 of Princeton.java and Harvard.java, the stack of bullets was created by pushing the bullets, assigning each player a maximum limit of 5000 bullets. Finally, the bullets are shot by the players with the shoot() method on lines 88 - 103 of the Princeton.java and Harvard.java by popping a bullet from the stack. 

G. List the two custom methods written by your project group
Include method signatures and line numbers.
If your project group wrote more than two custom functions, choose the 
two functions that were most extensively tested.

Move() method in both Princeton.java and Harvard.java on lines 58 - 67, which moves the tiger or pilgrim up and down. 
public void move(int direction1) {

Aim() method in both Princeton.java and Harvard.java on lines 74 - 78, which rotates the tiger or pilgrim counterclockwise or clockwise by given angle. 

public void aim(double direction) {

H. List the line numbers where you test each of your two custom methods twice.
For each of the four tests (two for each method), explain what was being
tested and the expected result. For non-textual results (e.g. graphical or
auditory), you may describe in your own words what the expected result
should be or reference output files (e.g. images, audio files).

Move() method is tested in Princeton.java in line 155, where the tiger moves down by 2 units because given velocity is 0.2 and the direction given is -10.

Move() method is tested in Princeton.java again in line 166, but this time tiger moves further down by 10 units, which means that the tiger is out of the set bottom boundary of -10 (tiger is out of the game board). This is to test the corner case and so standard output will print out the designated message "Ouch! Hit the wall!".

Aim() method is tested in Princeton.java in line 156, where the tiger rotates counterclockwise by 10 degrees. 

Aim() method is tested again in Princeton.java in line 167, but this time the tiger rotates too much (will shoot behind him, so we don't let him rotate at all), so this is to also test boundary case and so standard output will print the designated message "Whoops! Improve your aim!". 

Citing Resources
A. List below EVERY resource your project group looked at
Bullet lists and links suffice.

https://docs.google.com/document/d/1UDJnP6TmRtTQSR_BymqyS9L-WKvX0p15PkACTtTvwNA/edit#
https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html#
https://d368g9lw5ileu7.cloudfront.net/races/race102753-social1200x630.bFQSzY.jpg
https://www.freeiconspng.com/uploads/gun-png-clipart-20.png
https://www.washingtonpost.com/graphics/sports/ncaa-march-madness-emoji/img/mascots/harvardCrimson.png?c=1
https://www.pngkey.com/png/full/895-8950655_vibrant-design-clipart-gun-clipart-image-of-gun.png
https://docs.google.com/presentation/d/1LcNz1OIjDB_8lsppEYVuKxRrLCpJA54_UKpvtjmGNbs/edit#slide=id.p
https://www.remove.bg/
https://www.loom.com/share/0d33316f03444e0c8a8c4ca9def30038
https://www.cs.princeton.edu/courses/archive/spr22/cos126/gallery/
https://media.istockphoto.com/vectors/garland-with-flags-1-vector-id1181871089?k=20&m=1181871089&s=612x612&w=0&h=B-rOCUmNXO1tQ8_J7MchqZBoEENdCsdNq_42rkGtrwM=
https://edstem.org/us/courses/18194/discussion/1457658
https://docs.oracle.com/javase/8/docs/api/java/awt/Font.html?is-external=true
https://introcs.cs.princeton.edu/java/15inout/BouncingBall.java.html
https://introcs.cs.princeton.edu/java/11cheatsheet/
https://www.cs.princeton.edu/courses/archive/spr22/cos126/assignments/nbody/
B. Did you cite every resource that influenced your code in the code itself?
Every resource that informed your code should be cited in a comment at/near the
line(s) of code that it informed.

Yes or No? Yes

C. Did you receive help from classmates, past COS 126 students, or anyone else?
If so, please list their names. ("A Sunday lab TA" or "Office hours on
Thursday" is ok if you don't know their name.)

Yes or No? Yes, Donna Gabai

D. Did you encounter any serious problems? If so, please describe.
Yes or No? No

E. List any other comments here.
This represents our own work in accordance with University regulations. 

Submission Checklist
Please mark that you’ve done all of the following steps
(fill in square bracket with x, i.e. x):

Created a project.zip file, unzipped its contents, and checked that our
  compile and run commands work on the unzipped contents. Ensure that the .zip
  file is under 50MB in size.
Created and uploaded a Loom or YouTube video that...
is maximum 2 minutes in length 
demonstrates live your program's input(s) and output(s)
demonstrates live your 3 features
does not reveal any code
includes your project name and the name of each student
has its thumbnail and/or starting frame set to an image of your program
    or a title slide
is publicly viewable (check in an incognito browser)
is linked to in this implementation.md file (Q10 under Basic Information)  
Uploaded all .java files to TigerFile. Each .java file should be uploaded 
    separately as an additional file.
Uploaded project.zip file to TigerFile.
After you’ve submitted the above on TigerFile, remember to do the following:

Complete and upload this implementation.md file to TigerFile.
Complete and submit this Google Form
  (https://forms.cs50.io/27ca51e0-4d81-4d97-8621-ba1e5d26cd78).
Partial Credit: Bug Report(s)
For partial credit for buggy features, you may include a bug report for at
most 4 bugs that your project group was not able to fix before the submission
deadline. For each bug report, copy and paste the following questions and
answer them in full. Your bug report should be detailed enough for the grader
to reproduce the bug.

*Note: if your code appears bug-free, you should not submit any bug reports.*

BUG REPORT #1:
1. Describe in a sentence or two the bug below.

2. Describe in detail how to reproduce the bug (e.g. run commands, user input, 
etc.).

3. Describe the resulting effect of bug and provide evidence
(e.g. copy-and-paste the buggy output, reference screenshot files and/or buggy
output files, include a Loom video of reproducing and showing the effects of
the bug, etc.).

4. Describe where in your program code you believe the bug occurs (e.g. line
numbers).

5. Please describe what steps you tried to fix the bug.

Extra Credit
A. Going above and beyond the scope of COS126
Did your program go above and beyond the scope of COS126?
Yes or No?

If yes, please answer the following question.

Describe in detail how your program went above and beyond the scope of COS126.
B. Runtime Analysis
Did you analyze the efficiency of a substantial component of your project?
Yes or No?

If yes, please answer the following questions.

1. Specify the scope of the component you are analyzing
(e.g. function name, starting and ending lines of specific .java file).

2. What is the estimated runtime (e.g. big-O complexity) of this component?
Provide justification for this runtime (i.e. explain in your own words why
you expect this component to have this runtime performance).

3. Provide experimental evidence in the form of timed analysis supporting this
runtime estimate. (Hint: you may find it helpful to use command-line
arguments/flags to run just the specified component being analyzed).

C. Packaging project as an executable .jar file
Did you package your project as an executable .jar file?
Yes or No?

If yes, please answer the following question.

Describe in detail how to execute your .jar application (e.g. what execution command to use on the terminal).
Include a few example execution commands and the expected results of running
your program. For non-textual outputs (e.g. graphical or auditory), feel free
to describe in words what the output should be or reference output files
(e.g. images, audio files) of the expected output.