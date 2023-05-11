package objetos;

import java.util.ArrayList;

public class GerenciadorObjetos{
   public ArrayList<Objeto> objetos = new ArrayList<Objeto>();

   public void adicionarObjetos(){
      Plataforma plataforma1 = new Plataforma(720, 680, 200, 20);
      objetos.add(plataforma1);
   }
}
