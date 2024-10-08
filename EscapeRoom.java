/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Create an escape room game where the player must navigate
 * to the other side of the screen in the fewest steps, while
 * avoiding obstacles and collecting prizes.
 */
public class EscapeRoom
{

      // describe the game with brief welcome message
      // determine the size (length and width) a player must move to stay within the grid markings
      // Allow game commands:
      //    right, left, up, down: if you try to go off grid or bump into wall, score decreases
      //    jump over 1 space: you cannot jump over walls
      //    if you land on a trap, spring a trap to increase score: you must first check if there is a trap, if none exists, penalty
      //    pick up prize: score increases, if there is no prize, penalty
      //    help: display all possible commands
      //    end: reach the far right wall, score increase, game ends, if game ended without reaching far right wall, penalty
      //    replay: shows number of player steps and resets the board, you or another player can play the same board
      // Note that you must adjust the score with any method that returns a score
      // Optional: create a custom image for your player use the file player.png on disk
    

  public static void main(String[] args) 
  {      
    // welcome message
    String name;
    System.out.println("Welcome to EscapeRoom!");
    System.out.println("Get to the other side of the room, avoiding walls and invisible traps,");
    System.out.println("pick up all the prizes.\n");
    
    GameGUI game = new GameGUI();
    game.createBoard();

    // size of move
    int m = 60; 
    // individual player moves
    int px = 0;
    int py = 0; 
    
    int score = 0;


/* define Scanner, commands and scores*/
/* set up scanner input, valid commands, and score varialbe */
    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?", "check", "c", "spring", "s"};
    int length = validCommands.length;
    score = 0;
    // set up game
    /* leaderboard setup*/
    ArrayList<Integer> leaderboard = new ArrayList<Integer>();
    boolean play = true;
    while (play){
      score = 0;
      System.out.println("Commands for the game type: ? ");
      System.out.print("Enter command: ");
      String command = in.nextLine().toLowerCase();
      switch(command){
        //movement decided by switch statements the value m is 60 and determines how far the player moves
        case "right":
        case "r":
          game.movePlayer(m,0);
          px = px +m;
          break;
        case "left":
        case "l":
          game.movePlayer(-m,0);
          px= px -m;
          break;
        case "up":
        case "u":
          game.movePlayer(0,-m);
          py = py - m;
          break;
        case "down":
        case "d":
          game.movePlayer(0,m);
          py = py +m;
          break;
        case "jumpleft":
        case "jl":
          game.movePlayer(-m*2,0);
          px = px -m*2;
          break;
        case "jumpright":
        case "jr":
          game.movePlayer(m*2,0);
          px = px + m*2;
          break;
        case "jumpup":
        case "ju":
          game.movePlayer(0,-m*2);
          py = py - m*2;
          break;
        case "jumpdown":
        case "jd":
          game.movePlayer(0,m*2);
          py = py + m*2;
          break;
        case "pickup":
        case "p":
          score +=1;
          game.pickupPrize();
          break;
        case "check":
        case "c":
        game.isTrap( 0, 0);
        break;
        case "spring":
        case "s":
        game.springTrap(0, 0);

        break;
        case "?":
        case "help":
        for (int i = 0; i < length; i++){
          System.out.println(validCommands[i]);
        }
        break;
        //quits the game
        case "quit":
        case "q":
          play = false;
          break;
      } 
    }
    // asks user for name
    System.out.print("Enter name: ");
    name = in.nextLine();
    // if name contains any arbritrary characters then it is invalid
    if(name.equals("$%^") || name.equals("@#$")){
      System.out.println("INVALID INPUT!");
    }
    // final score
    score += game.endGame();
    leaderboard.add(score);
    for( int i =0; i < leaderboard.size(); i ++){
      System.out.print(name + ": " + leaderboard.get(i));
    }
    System.out.println(" score=" + score);
    System.out.println("steps=" + game.getSteps());
  }

}

