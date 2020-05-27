/*  Name: Vishaal Kumar 
 *  PennKey: vishaalk
 *  Recitation: 215
 *
 *  Execution: java Game
 *
 *  Represents the 2048 game. This is the class where the main game runs.
 *  All the required objects are created in this class
 *
 */

public class Game {
  
  public static void main(String[] args) {
    start();
  }
  
  /**
   * Description: Function that starts the game. Created it as a seperate function
   * in order to implement the restart feature. 
   * 
   * Input: No input
   * 
   * Output: The game starts/restarts with a fresh grid and score
   */
  public static void start() {
    
    //Initialize a new game screen with a fresh grid
    GameScreen gameScreen = new GameScreen(new Grid());
    //Adding the 2 initial random numbers onto the grid.
    gameScreen.getGrid().addNumber();
    gameScreen.getGrid().addNumber();
    //Drawing the grid
    gameScreen.drawBaseGameScreen();
    PennDraw.enableAnimation(60);
    
    //Listening for any keyboard presses and executing appropiate functionality
    while (true) {
      if (PennDraw.hasNextKeyTyped()) {
        char entry = PennDraw.nextKeyTyped();
        switch (entry) {
          case 'W':
          case 'w': gameScreen.getGrid().action(3);
          break;
          case 'S':
          case 's': gameScreen.getGrid().action(4);
          break;
          case 'D':
          case 'd': gameScreen.getGrid().action(2);
          break;
          case 'A':
          case 'a': gameScreen.getGrid().action(1);
          break;
          default :
            break;
        }     
        //Redraw screen based on whatever keyboard key was pressed
        gameScreen.drawBaseGameScreen();
        PennDraw.advance();
        //Check if game is over - Either Player has lost or won the game
        if (gameScreen.getGrid().isGameOver()) {
          break;
        }       
      }
    }
    
    //Judging which end screen to show
    if (gameScreen.getGrid().isGameWon()) {
      gameScreen.drawGameWinScreen();
      PennDraw.advance();
    } else {
      gameScreen.drawGameLostScreen();
      PennDraw.advance();
    }
    
    //Loop that checks if player wants to play again
    while (true) {
      if (PennDraw.hasNextKeyTyped()) {
        char entry = PennDraw.nextKeyTyped();
        if (entry == 'R' || entry == 'r') {
          start();
        }
      }
    }
  }
}