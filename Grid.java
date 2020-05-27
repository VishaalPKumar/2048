/*  Name: Vishaal Kumar 
 *  PennKey: vishaalk
 *  Recitation: 215
 *
 *  Execution: java Grid
 *
 *  Description :- Class that contains the main game logic of how the grid
 *  and pieces interact with each other
 *
 */
public class Grid {  
  
  //Constants
  private int GRID_SIZE = 4; //Determines the size of the 2D Array  
  //Field Variables
  private Piece[][] gridArray = new Piece[GRID_SIZE][GRID_SIZE];
  private int moveCounter;
  
  /**
   * Description: Constructor - creates an empty Grid object
   * 
   * Input: No input
   * 
   * Output: the grid array is initialized and moveCounter is set to 0
   */
  public Grid() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        gridArray[i][j] = new Piece();
      }
    }  
    moveCounter = 0;
  }
  
  /**
   * Description: Adds a 2 or 4 to the grid randomly
   * 
   * Input: No input
   * 
   * Output: A piece in the gridArray has a value set to either 2 or 4
   */
  public void addNumber() {
    //Deciding between adding a 2 or 4
    int addNum = 2; 
    double randomNum = Math.random();
    if (randomNum < 0.5) {
      addNum = 4;
    }
    //Deciding where in the grid array the number needs to be added
    int columnIndex = (int) (Math.random() * GRID_SIZE);
    int rowIndex = (int) (Math.random() * GRID_SIZE);
    //Checking if the area in the grid is empty
    if (!gridArray[rowIndex][columnIndex].isEmpty()) {
      addNumber();
    }
    else {
      gridArray[rowIndex][columnIndex].setValue(addNum);
    }      
  }
  
  /**
   * Description: Function that is called when a button is pressed. The movement
   * of pieces occurs here
   * 
   * Input: an integer that resembles whether to move pieces up, left, right or
   * down
   * 
   * Output: The pieces in the grid 'move'
   */
  public void action(int movementKey) {
    //a flag to check if the pieces moved successfully
    int checker = 0;
    
    Piece[] subArray = new Piece[GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
      //Dividing the large 2D grid into different subArrays based on the direction
      //of movement
      subArray = subArrayCreator(movementKey, i);
      while (isMovementPossible(subArray)) {
        //Helper functions that merge similar pieces and then shifts them
        //according to the specified movement key
        mergePieces(subArray);
        shiftPieces(subArray);
        //movement successful
        checker += 1;
      }
      //Repopulating the gridArray
      if (movementKey == 1) {
        for (int j = 0; j < GRID_SIZE; j++) {
          this.gridArray[j][i].setValue(subArray[j].getValue());
        }
      } else if (movementKey == 2) {
        for (int j = 0; j < GRID_SIZE; j++) {
          this.gridArray[GRID_SIZE - (j + 1)][i].setValue(subArray[j].getValue());
        }
      } else if (movementKey == 3) {
        for (int j = 0; j < GRID_SIZE; j++) {
          this.gridArray[i][j].setValue(subArray[j].getValue());
        }
      } else {
        for (int j = 0; j < GRID_SIZE; j++) {
          this.gridArray[i][GRID_SIZE - (j + 1)].setValue(subArray[j].getValue());
        }
      }
    }
    //Add a random number if move was successful and increment the move counter
    if (checker != 0) {
      this.addNumber();
      moveCounter++;
    }
  }
  
  /**
   * Description: Checking if game is over
   * 
   * Input: No input
   * 
   * Output: a boolean that is true if game is over
   */
  public boolean isGameOver() {
    return isGameWon() || isGameLost();
  }
  
  /**
   * Description: Checking if player has won the game
   * 
   * Input: No input
   * 
   * Output: returns a boolean that is true if players has won the game
   */
  public boolean isGameWon() {
    if (this.getScore() == 2048) {
      return true;
    }
    return false;
  }
  
  /**
   * Description: Checking if player has lost the game
   * 
   * Input: No input
   * 
   * Output: returns a boolean that is true if players has lost the game
   */
  public boolean isGameLost() {
    
    Piece[] subArray = new Piece[GRID_SIZE];
    //multiple loops are required to check if movement is not possible
    //in all 4 directions
    for (int index = 0; index < GRID_SIZE; index++) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = new Piece(this.gridArray[i][index].getValue());    
      }
      if (isMovementPossible(subArray)) {
        return false;
      }
    }
    for (int index = 0; index < GRID_SIZE; index++) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = 
          new Piece(this.gridArray[GRID_SIZE - (i + 1)][index].getValue()); 
      }
      if (isMovementPossible(subArray)) {
        return false;
      }
    }
    for (int index = 0; index < GRID_SIZE; index++) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = new Piece(this.gridArray[index][i].getValue());       
      }
      if (isMovementPossible(subArray)) {
        return false;
      }
    }
    for (int index = 0; index < GRID_SIZE; index++) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = 
          new Piece(this.gridArray[index][GRID_SIZE - (i + 1)].getValue());     
      }
      if (isMovementPossible(subArray)) {
        return false;
      }
    }   
    return true;   
  }
  
  /**
   * Description: Getter method for the grid array
   * 
   * Input: No input
   * 
   * Output: returns the gridArray of the Grid object
   */
  public Piece[][] getGridArray() {
    return this.gridArray;
  }
  
  /**
   * Description: Getter method for the score
   * 
   * Input: No input
   * 
   * Output: returns the score of the Grid object which is the largest value of
   * all the pieces in the grid.
   */
  public int getScore() {
    int max = 0;
    for (Piece[] arr:this.gridArray) {
      for (Piece piece:arr) {
        if (piece.getValue() > max) {
          max = piece.getValue();
        }
      }
    }
    return max; 
  }
  
  /**
   * Description: Getter method for the move counter
   * 
   * Input: No input
   * 
   * Output: returns the move counter of the Grid object
   */
  public int getMoveCounter() {
    return this.moveCounter;
  }
  
//Helper Functions
  
  
  /**
   * Description: Helper function that is responsible for only shifting the pieces.
   * Shifting only happens in the left direction
   * 
   * Input: the array that needs to be shifted to the left
   * 
   * Output: no output - void
   */
  private void shiftPieces(Piece[] pieceArray) {
    for (int i = 1; i < pieceArray.length; i++) {
      if (pieceArray[i - 1].isEmpty()) {
        pieceArray[i - 1].setValue(pieceArray[i].getValue()); 
        pieceArray[i].clearPiece();       
      }
    }
  }
  
  /**
   * Description: Helper function that is responsible for merging the pieces.
   * Merging only happens in the left direction
   * 
   * Input: the array that needs to be merged
   * 
   * Output: no output - void
   */
  private void mergePieces(Piece[] pieceArray) {
    for (int i = 1; i < pieceArray.length; i++) {
      if (pieceArray[i - 1].isEqualTo(pieceArray[i])) {
        pieceArray[i - 1].setValue(pieceArray[i - 1].getValue() + 
                                 pieceArray[i].getValue());
        pieceArray[i].clearPiece();
        
      }
    }
  }
  
  /**
   * Description: This function creates subArrays based on the direction
   * specified. 
   * 
   * Input: the integer key that specifies the movement, and an integer index
   * that helps to specifiy the constant row or column index to read from
   * 
   * Output: A one dimensional piece array
   */
  private Piece[] subArrayCreator(int movementKey, int index) {
    Piece[] subArray = new Piece[GRID_SIZE];
    
    if (movementKey == 1) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = new Piece(this.gridArray[i][index].getValue());
      }
    } else if (movementKey == 2) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = 
          new Piece(this.gridArray[GRID_SIZE - (i + 1)][index].getValue());
      }
    } else if (movementKey == 3) {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = new Piece(this.gridArray[index][i].getValue());
      }
    } else {
      for (int i = 0; i < GRID_SIZE; i++) {
        subArray[i] = 
          new Piece(this.gridArray[index][GRID_SIZE - (i + 1)].getValue());
      }
    }
    return subArray;
  }
  
  /**
   * Description: Helper function that is responsible to check if movement to
   * the left is possible in the inputted 1-D array
   * 
   * Input: A 1-D Piece Array
   * 
   * Output: a boolean value that is true if movement to the left is possible
   */
  private boolean isMovementPossible(Piece[] array) {
    for (int i = 0; i < GRID_SIZE - 1; i++) {
      if ((array[i].isEmpty() && !array[i + 1].isEmpty()) || 
          (array[i + 1].isEqualTo(array[i]) && !array[i + 1].isEmpty())) {
        return true;
      }
    }
    return false;
  }
}
