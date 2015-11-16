/**
 * @author Daniel McKinnon
 */
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color.*;

public class TootAndOtto implements ActionListener{
  private int row = 6;
  private int column = 6;
  private JFrame window = new JFrame("Toot and Otto");
  private boolean win = false;
  private JPanel board;
  private JButton[][] button;
  private boolean filledletter = false;
  
  /** @constructor A constructor that takes no inputs
    */
  public TootAndOtto() {
    new TootAndOtto(6,6);
  }
  
  /** @constructor A constructor 
    * @param Number of rows
    * @param Number of columns
    */
  public TootAndOtto(int row, int column) {
    this.board = new JPanel(new GridLayout(row, column));
    window.setContentPane(board);
    window.setSize(100*row, 100*column);   
    this.button = new JButton[row][column];
    for (int i = 0; i <= row - 1; i++) {
      for (int j = 0; j <= column - 1; j++) {
        button[i][j] = new JButton();
        button[i][j].addActionListener(this);
        this.board.add(button[i][j]);
        button[i][j].setText("");
      }
    }
    window.setVisible(true); 
  }
  
  /**
   * The action for when the button is pressed
   */
  public void actionPerformed(ActionEvent e){
    JButton b = (JButton)e.getSource();
    int c = findColumn(b);
    int r = findRow(b, c);
    this.addText(b,c);
    this.checkVertical(c);
    this.checkHorizontal(r);
  }
  
  /**Returns the coluum of a JButton
    * @param A JButton in TootAndOtto
    */
  public int findColumn(JButton b){
    int r = 0;
    for(int i = 0; i <= row-1; i++){
      for(int j = 0; j<= column-1; j++){
        if(b.equals(button[i][j])){
          r = j;
        }
      }
    }
    return r;
  }
  
    /**Returns the row of a JButton
    * @param A JButton in TootAndOtto
    */
  public int findRow(JButton b, int c){
    int r = 0;
    for(int i = 0; i<= row -1; i++){
      if(b.equals(button[i][c])){
        r = i;
      }
    }
    return r;
  }
  
    /**Adds either a T or O to a button
    * @param A JButton in TootAndOtto
    * @the column of the button pressed
    */
  public void addText(JButton b, int c){
    boolean clickmade = true;
    for(int i = row-1; i>= 0; i--){
      if(clickmade == true){
        if((filledletter == false)&&(button[i][c].getText() == "")){
          button[i][c].setText("T");
          filledletter = true;
          clickmade = false;
        } else if((filledletter == true)&&(button[i][c].getText() == "")){
          button[i][c].setText("O");
          filledletter = false;
          clickmade = false;
        } 
      }
    }
  }
  /**
   *Looks for the word TOOT in a column
   * @param The column where the last button was pressed
   */
  public boolean checkVertical(int col){
    StringBuilder vertical = new StringBuilder();
    int indexcolumn = -1;
    boolean check = false;
    //Checks for the vertical Toot
    for(int i = 0; i < this.row; i++){
      vertical.append(button[i][col]);
    }
    indexcolumn = vertical.toString().indexOf("TOOT");
    if(indexcolumn > -1){
      System.out.print("Two");
      for(int i = indexcolumn; i < indexcolumn + 4; i++){
        button[i][col].setBackground(Color.yellow);
        check = true;
      }
    }
    return check;
  }
  
  /**
   * Looks for the word TOOT in a row
   * @param The row where the last button was pressed
   */
  public boolean checkHorizontal(int ro){
    StringBuilder horizontal = new StringBuilder();
    int indexrow = -1;
    boolean check = false;
    //Checks for the vertical Toot
    for(int i = 0; i < this.column; i++){
      horizontal.append(button[i][ro]);
    }
    indexrow = horizontal.toString().indexOf("TOOT");
    if(indexrow > -1){
      System.out.print("Three");
      for(int i = indexrow; i < indexrow + 4; i++){
        button[i][ro].setBackground(Color.yellow);
        check =  true;
      }
    }
    return check;
  }
  
  /**Checks for a diaganol TOOT or OTTO
    * @param int the vertical loaction of a button
    * @param the horozontal location of a button
    */
  public boolean checkDiaganol(int ro, int col){
    StringBuilder diaganol = new StringBuilder();
    int xindex = -1;
    int yindex = -1;
    int col2 = 0;
    boolean check = false; 
      if(col>ro){
      for(int i = ro; i > -1; i--){
        col = col -1;
        col2 = col;
      }
      for(int i = 0; i < ro; i++){
        diaganol.append(button[i][col]);
        col = col +1;
        col = col2;
      }
      yindex = diaganol.toString().indexOf("TOOT");
      if(yindex > -1){
        for(int i = yindex; i < yindex + 4; i++){
          button[i][col].setBackground(Color.yellow);
          col = col + 1 ;
          check = true;
        }
      }
    }
    return check;
  }
}



