package objetos;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class GerenciadorObjetos{
   public ArrayList<Objeto> objetos = new ArrayList<Objeto>();
   int larguraPlataforma = 100;
   int alturaPlataforma = 20;

   public void adicionarObjetos(){
      Plataforma plataforma1 = new Plataforma(720, 660, larguraPlataforma, alturaPlataforma);
      objetos.add(plataforma1);

      Plataforma plataforma2 = new Plataforma(800, 590, larguraPlataforma, alturaPlataforma);
      objetos.add(plataforma2);

      Plataforma plataforma3 = new Plataforma(880, 510, larguraPlataforma, alturaPlataforma);
      objetos.add(plataforma3);

      for(int i = 0; i < 8; i++){
         objetos.add(new Plataforma(1100, 100+(i*80), larguraPlataforma, alturaPlataforma));
      }

      objetos.add(new Plataforma(240, 40, 20, 600));
   }


   public void desenharObjetos(Graphics2D g2){
      //objetos
      for(int i = 0; i < objetos.size(); i++){
         if(objetos.get(i) != null){
            g2.setColor(objetos.get(i).cor);
            g2.fillRect(
            (int)objetos.get(i).x, 
            (int)objetos.get(i).y, 
            (int)objetos.get(i).largura, 
            (int)objetos.get(i).altura);
         }
      }      
   }
}
