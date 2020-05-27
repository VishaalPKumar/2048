/*  Name: Vishaal Kumar 
 *  PennKey: vishaalk
 *  Recitation: 215
 *
 *  Execution: java GameScreen
 *
 *  Description :- Class that is responsible for drawing all the 
 *  components of the game.
 *
 */
public class GameScreen {
  
  //Size of each Piece
  private static final double SQUARE_SIZE = 0.1;
  

  private Grid grid = new Grid();
  
    /**
   * Description: Constructor - creates an empty GameScreen object
   * 
   * Input: A Grid object
   * 
   * Output: A GameScreen object is created with its grid object set.
   */
  public GameScreen(Grid grid) {
    this.grid = grid;
  }
  
   /**
   * Description: Function that draws the entire screen by calling other helper
   * functions
   * 
   * Input: No input
   * 
   * Output: The main screen is drawn
   */
  public void drawBaseGameScreen() {
    PennDraw.clear(223, 213, 201);
    PennDraw.setFontBold();
    PennDraw.setPenColor(PennDraw.BLACK);
    PennDraw.setFontSize(10);
    PennDraw.text(.60, .95, "Use the 'WASD' keys to move the tiles.");
    PennDraw.text(.60, .92, "Try and getting the numbers to add up to 2048!");
    PennDraw.text(.09, .88, "Score:- " + grid.getScore());
    PennDraw.text(.29, .88, "Number of Moves:- " + grid.getMoveCounter());
    PennDraw.setFontSize(40);
    PennDraw.setPenColor(119, 111, 101);
    PennDraw.text(.20, .93, "2048");
    drawGameBoard();
    drawGridValues();
  }
   /**
   * Description: Function that draws the game over screen
   * 
   * Input: No input
   * 
   * Output: The "you lost" screen is drawn
   */
  public void drawGameLostScreen() {
    PennDraw.clear(PennDraw.BLACK);
    PennDraw.setPenColor(PennDraw.WHITE);
    PennDraw.setFontSize(20);
    PennDraw.text(0.5, 0.5, "Game Over. You Lost");
    PennDraw.text(0.5, 0.55, "Your Score was " + grid.getScore());
    PennDraw.text(0.5, 0.60, "Number of Moves - " + grid.getMoveCounter());
    PennDraw.text(0.5, 0.65, "Press 'R' key to play again");   
  }
   /**
   * Description: Function that draws the win screen
   * 
   * Input: No input
   * 
   * Output: The win screen is drawn
   */
  public void drawGameWinScreen() {
    PennDraw.clear(PennDraw.BLACK);
    PennDraw.setPenColor(PennDraw.WHITE);
    PennDraw.setFontSize(20);
    PennDraw.text(0.5, 0.5, "Congratulations! You Won!");
    PennDraw.text(0.5, 0.55, "Your Score was " + grid.getScore());
    PennDraw.text(0.5, 0.60, "Number of Moves - " + grid.getMoveCounter());
    PennDraw.text(0.5, 0.65, "Press 'R' key to play again");
    
  }
   /**
   * Description: Function that draw the specific grid values and sets
   * the style of the text in the pieces
   * 
   * Input: No input
   * 
   * Output: The data of each piece is drawn on the board grid.
   */
  private void drawGridValues() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        PennDraw.setFontBold();
        //Checking the value of the piece in order to identify what color
        //the text should be
        if (this.grid.getGridArray()[i][j].getValue() > 4) {
          PennDraw.setPenColor(PennDraw.WHITE);
        }
        else {
          PennDraw.setPenColor(125, 115, 105);
        }
        PennDraw.setFontSize(35);
        PennDraw.text(.2 + i * .2, .75 + j * -.2, "" + 
                      this.grid.getGridArray()[i][j].toString());
      }
    }
  }
  
    /**
   * Description: Function that draw the specific grid squares and sets
   * the style of pieces using a helper function
   * 
   * Input: No input
   * 
   * Output: The pieces are drawn on the gameboard
   */
  private void drawGameBoard() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        int value = this.grid.getGridArray()[i][j].getValue();
        int[] colors = colorPicker(value);
        PennDraw.setPenColor(colors[0], colors[1], colors[2]);
        PennDraw.filledSquare(.2 + i * .2, .75 + j * -.2, SQUARE_SIZE);
        PennDraw.setPenColor(164, 147, 129);
        PennDraw.setPenRadius(0.020);
        PennDraw.square(.2 + i * .2, .75 + j * -.2, SQUARE_SIZE);
      }
    }
  }
  
  
 /**
   * Description: Helper function that determines the RGB integer values
   * depending on the value of a piece in the grid
   * 
   * Input: The integer value of a certain Piece
   * 
   * Output: an integer array containing the RGB integer values
   */
  private static int[] colorPicker(int value) {
    int[] colors = new int[3];
    switch (value) {
      case 0 : 
        colors[0] = 223;
        colors[1] = 213;
        colors[2] = 201;
        break;
      case 2 : 
        colors[0] = 238;
        colors[1] = 228;
        colors[2] = 218;
        break;
      case 4 : 
        colors[0] = 236;
        colors[1] = 224;
        colors[2] = 200;
        break;
      case 8 : 
        colors[0] = 245;
        colors[1] = 149;
        colors[2] = 99;
        break;
      case 16 : 
        colors[0] = 245;
        colors[1] = 130;
        colors[2] = 97;
        break;
      case 32 : 
        colors[0] = 246;
        colors[1] = 125;
        colors[2] = 96;
        break;
      case 64 : 
        colors[0] = 246;
        colors[1] = 96;
        colors[2] = 61;
        break;
      case 128 : 
        colors[0] = 237;
        colors[1] = 205;
        colors[2] = 97;
        break;
      case 256 : 
        colors[0] = 237;
        colors[1] = 204;
        colors[2] = 90;
        break;
      case 512 : 
        colors[0] = 238;
        colors[1] = 201;
        colors[2] = 84;
        break;
      case 1024 : 
        colors[0] = 236;
        colors[1] = 198;
        colors[2] = 65;
        break;
      case 2048 : 
        colors[0] = 0;
        colors[1] = 0;
        colors[2] = 0;
        break;
      default :
        colors[0] = 0;
        colors[1] = 0;
        colors[2] = 0;
        break;    
    }
    return colors;
  }
  
  /**
   * Description: Getter method for the grid
   * 
   * Input: No input
   * 
   * Output: the Grid of the object is returned
   */
  public Grid getGrid() {
    return this.grid;
  }
}