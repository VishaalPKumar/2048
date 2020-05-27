/*  Name: Vishaal Kumar 
 *  PennKey: vishaalk
 *  Recitation: 215
 *
 *  Execution: java Piece
 *
 *  Description :- Piece class that contains all the fields and methods for a 
 *  Piece object. 
 *
 */
public class Piece {
  
  //Fields
  private int value;
  
  /**
   * Description: Constructor - creates an empty Piece object
   * 
   * Input: No input
   * 
   * Output: the value of the piece is set to 0
   */
  public Piece() {
    this.value = 0;
  }
  
  /**
   * Description: Constructor - creates a Piece object
   * 
   * Input: the integer value
   * 
   * Output: the value of the piece is set to the input
   */
  public Piece(int value) {
    this.value = value;
  }
  
  /**
   * Description: Setter method for the value field
   * 
   * Input: the integer value
   * 
   * Output: the value of the piece is set to the input
   */
  public void setValue(int value) {
    this.value = value;
  }
  
  /**
   * Description: Getter method for the value field
   * 
   * Input: No input
   * 
   * Output: the integer value field of the object is returned
   */
  public int getValue() {
    return value;
  }
  
  /**
   * Description: Merge results in the addition of the value of the input piece
   * with the value of the current object. 
   * 
   * Input: the Piece object that merges with the current Piece object
   * 
   * Output: no output - void
   */
  public void merge(Piece piece) {
    this.value = this.value + piece.getValue();
  }
  
  /**
   * Description: Clear piece by setting its value to 0
   * 
   * Input: no input
   * 
   * Output: no ouput - void - the value of the piece is set to 0
   */
  public void clearPiece() {
    this.value = 0;
  }
  
  /**
   * Description: checks if two pieces have the same value
   * 
   * Input: the piece object that the current object is being compared with
   * 
   * Output: a boolean that is true if the values match
   */
  public boolean isEqualTo(Piece piece) {
    return this.value == piece.getValue();
  }
  /**
   * Description: checks if the piece object has a value of 0
   * 
   * Input: no input
   * 
   * Output: a boolean that is true if the value is 0
   */
  public boolean isEmpty() {
    return this.value == 0;
  }
  /**
   * Description: Converting the piece object to a string variable
   * 
   * Input: no input
   * 
   * Output: a String variable that is the string equivalent of the piece's value
   */
  public String toString() {
    if (this.isEmpty()) { 
      return "";
    }
    else {
      return "" + this.value;
    }
  }
}