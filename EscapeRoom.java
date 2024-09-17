/*
* Problem 1: Escape Room
* 
* V1.0
* 10/10/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Scanner;

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
    
      /**** provided code:
      // set up the game
      boolean play = true;
      while (play)
      {
        // get user input and call game methods to play 
        play = false;
      }
      */

  public static void main(String[] args) 
  {      
    // welcome message
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


    Scanner in = new Scanner(System.in);
    String[] validCommands = { "right", "left", "up", "down", "r", "l", "u", "d",
    "jump", "jr", "jumpleft", "jl", "jumpup", "ju", "jumpdown", "jd",
    "pickup", "p", "quit", "q", "replay", "help", "?"};
    int length = validCommands.length;

    // set up game
    boolean play = true;
    while (play){
      
      score = 0;

      System.out.println("Commands for the game type: ? ");
      System.out.print("Enter command: ");
      String command = in.nextLine().toLowerCase();
      switch(command){
        case "right":
          game.movePlayer(m,0);
          break;
        case "r":
          game.movePlayer(m,0);
          break;
        case "left":
          game.movePlayer(-m,0);
          break;
        case "l":
          game.movePlayer(-m,0);
          break;
        case "up":
          game.movePlayer(0,-m);
          break;
        case "u":
          game.movePlayer(0,-m);
          break;
        case "down":
          game.movePlayer(0,m);
          break;
        case "d":
          game.movePlayer(0,m);
          break;
        case "jumpleft":
          game.movePlayer(-m*2,0);
          break;
        case "jl":
          game.movePlayer(-m*2,0);
          break;
        case "jumpright":
          game.movePlayer(m*2,0);
          break;
        case "jr":
          game.movePlayer(m*2,0);
          break;
        case "jumpup":
          game.movePlayer(0,-m*2);
          break;
        case "ju":
          game.movePlayer(0,-m*2);
          break;
        case "jumpdown":
          game.movePlayer(0,m*2);
          break;
        case "jd":
          game.movePlayer(0,m*2);
          break;
        case "pickup":
          score +=1;
          game.pickupPrize();
          break;
        case "p":
          score +=1;
          game.pickupPrize();
          break;
        case "?":
          for (int i = 0; i < length; i++){
            System.out.println(validCommands[i]);
          }
        case "help":
        for (int i = 0; i < length; i++){
          System.out.println(validCommands[i]);
        }
        case "quit":
          break;
        case "q":
          break;
      }
    }

    score += game.endGame();

    System.out.println("score=" + score);
    System.out.println("steps=" + game.getSteps());
  }
  }
}
