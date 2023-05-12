package structure;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LeitorTeclado implements KeyListener{

   public boolean w = false, a = false, s = false, d = false, espaco = false, enter = false;
   public boolean setaCima = false, setaBaixo = false; 


   public LeitorTeclado(){
      
   }


   @Override
   public void keyTyped(KeyEvent e){
   }

   @Override
   public void keyPressed(KeyEvent e){
      switch(e.getKeyCode()){
         case KeyEvent.VK_W: w = true; break;
         case KeyEvent.VK_A: a = true; break;
         case KeyEvent.VK_S: s = true; break;
         case KeyEvent.VK_D: d = true; break;
         case KeyEvent.VK_SPACE: espaco = true; break;//tratar pulo
         case KeyEvent.VK_ENTER: enter = true; break;
         case KeyEvent.VK_UP: setaCima = true; break;
         case KeyEvent.VK_DOWN: setaBaixo = true; break;         
      }
   }

   @Override
   public void keyReleased(KeyEvent e){
      switch(e.getKeyCode()){
         case KeyEvent.VK_W: w = false; break;
         case KeyEvent.VK_A: a = false; break;
         case KeyEvent.VK_S: s = false; break;
         case KeyEvent.VK_D: d = false; break;
         case KeyEvent.VK_SPACE: espaco = false; break;
         case KeyEvent.VK_ENTER: enter = false; break;
         case KeyEvent.VK_UP: setaCima = false; break;
         case KeyEvent.VK_DOWN: setaBaixo = false; break;   
      }
   }
   
}
