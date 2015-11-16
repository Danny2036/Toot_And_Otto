/** @author Daniel McKinnon
  */
import junit.framework.TestCase;
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color.*;

public class TootAndOttoTest extends TestCase{
  
  TootAndOtto x = new TootAndOtto();
  
  /** @Test
    */
  public void testFindColumn(){
    assertEquals(1, x.findColumn(x.button[1][1]));
    assertEquals(4, x.findColumn(x.button[1][4]));
    assertEquals(6, x.findColumn(x.button[1][6]));
  }
  
  /** @Test
    */
  public void testFindRow(){
    assertEquals(1, x.findColumn(x.button[1][1]));
    assertEquals(4, x.findColumn(x.button[4][4]));
    assertEquals(6, x.findColumn(x.button[6][6]));
  }
  
  /** @Test
    */
  public void testAddText(){
    assertEquals("T",  (x.addText(x.button[1][1], 1)).getText());
    assertEquals("O",  (x.addText(x.button[2][1], 1)).getText());
    assertEquals("T",  (x.addText(x.button[3][1], 1)).getText());
    assertEquals("O",  (x.addText(x.button[4][1], 1)).getText());
  }
}