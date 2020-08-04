# Pentago

Pentago is a two-player abstract strategy game invented by Tomas Flodén.
The game is played on a 6×6 board divided into four 3×3 sub-boards (or quadrants). Taking turns, the two players place a marble of their color (either black or white) onto an unoccupied space on the board, and then rotate one of the sub-boards by 90 degrees either clockwise or anti-clockwise. This is optional in the beginning of the game, up until every sub-board no longer has rotational symmetry, at which point it becomes mandatory (this is because until then, a player could rotate an empty sub-board or one with just a marble in the middle, either of which has no real effect). A player wins by getting five of their marbles in a vertical, horizontal or diagonal row (either before or after the sub-board rotation in their move). If all 36 spaces on the board are occupied without a row of five being formed then the game is a draw.
[(read more)](https://en.wikipedia.org/wiki/Pentago)

This was my AP(Advance Programming) course project of my university second semester 2019 - 2020 (1398 - 1399). It is a simple implementation of the Othollo game in Java (without GUI). 



## Installation

Just download the file of classes, put them on a same directory(a same folder).



## Usage

compile them(you must have JDK(Java Development Kit) on your system. you can download it from [here](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)) and then run the Run class.


comile step:
```bash
$ javac *.java
```
start the game:
```bash
$ java Run
```

WARNNIG: for a colorfull output in terminal, I used ANSI codes and some emojis. So you can't compile and run it on Windows OS.



## Contributing
This project has a simple AI (int Bot class) and dosen't have GUI. 
So pull requests are welcome for this parts or other changes that make it better



### A quick overview of classes:

* *Run*: the main class of the game (includes main method)
* *Rules*: for check the game rules and apply players chooses
* *Printer*: do all required outputs in terminal
* *Board*: the board of the game
* *Person*: hold the information of players
* *Player*: hold player score, character and ID
* *Bot*: a simple AI. plays instead of player2 in single player mode 



## some photos of project


![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/1.png)
![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/2.png)
![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/3.png)
![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/4.png)
![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/5.png)
![github-octocat](https://github.com/MmahdiM79/Pentago/blob/master/photos/6.png)