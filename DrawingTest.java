public class DrawingTest {
  public static void main(String[] args) {
    PennDraw.setCanvasSize(500,500);
    PennDraw.clear(PennDraw.BLACK);
    PennDraw.setPenColor(PennDraw.WHITE);
    PennDraw.setFontSize(10);
    PennDraw.text(.60, .95, "Use the 'WASD' keys to move the tiles.");
    PennDraw.text(.60, .90, "Try and getting the numbers to add up to 2048!");
    PennDraw.text(.15, .90, "Score:- ");
    PennDraw.setFontSize(40);
    PennDraw.text(.20, .95, "2048");
    PennDraw.setPenColor(PennDraw.ORANGE);
    PennDraw.filledRectangle(.2,.75,.1,.1);
    PennDraw.setFontSize(35);
    PennDraw.text(.2, .75, "2048");
    PennDraw.rectangle(.4,.75,.1,.1);
    PennDraw.rectangle(.6,.75,.1,.1);
    PennDraw.rectangle(.8,.75,.1,.1);
    
    PennDraw.rectangle(.2,.55,.1,.1);
    PennDraw.rectangle(.4,.55,.1,.1);
    PennDraw.rectangle(.6,.55,.1,.1);
    PennDraw.rectangle(.8,.55,.1,.1);
    
    PennDraw.rectangle(.2,.35,.1,.1);
    PennDraw.rectangle(.4,.35,.1,.1);
    PennDraw.rectangle(.6,.35,.1,.1);
    PennDraw.rectangle(.8,.35,.1,.1);
    
    PennDraw.rectangle(.2,.15,.1,.1);
    PennDraw.rectangle(.4,.15,.1,.1);
    PennDraw.rectangle(.6,.15,.1,.1);
    PennDraw.rectangle(.8,.15,.1,.1);
    
    
    
    
    
    
  }
}