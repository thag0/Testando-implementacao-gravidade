package structure;

import java.awt.Rectangle;

import entidade.PainelPrincipal;
import entidade.Player;
import objetos.GerenciadorObjetos;

public class Logica{
   LeitorTeclado leitorTeclado;
   PainelPrincipal painelPrincipal;
   GerenciadorObjetos gerenciadorObjetos;
   Player player;
   
   //movimento
   double velocidadeGavitacional = 0;
   boolean pulando = false;
   int contador_pulo = 0;
   double playerYInicialPulo;

   public Logica(PainelPrincipal painelPrincipal){
      this.painelPrincipal = painelPrincipal;
      this.leitorTeclado = painelPrincipal.leitorTeclado;
      this.player = painelPrincipal.player;
      this.gerenciadorObjetos = painelPrincipal.gerenciadorObjetos;
   }

   public void atualizar(){
      aplicarGravidade();
      movimentarPlayer();
      calcularColisao();
   }


   private void aplicarGravidade(){

      if(player.getY() <= (painelPrincipal.altura-player.getAltura()-velocidadeGavitacional) && player.getMover()){
         velocidadeGavitacional += 0.25;
         player.setY(player.getY()+velocidadeGavitacional);

      }else{
         velocidadeGavitacional = 0;
      }
   }


   private void movimentarPlayer(){
      if(leitorTeclado.a && ((player.getX() - player.getVelocidade()) >= 0)){
         player.setX(player.getX() - player.getVelocidade());
      }
      if(leitorTeclado.d && ((player.getX() + player.getVelocidade()) <= (painelPrincipal.largura-player.getLargura()))){
         player.setX(player.getX() + player.getVelocidade());
      }

      gerenciarPulo();
   }


   public void gerenciarPulo(){
      if(leitorTeclado.espaco){
         pulando = true;
         playerYInicialPulo = player.getY();
      }

      if(pulando && player.getMover()){
         if(player.getY() <= (playerYInicialPulo)) player.setY(player.getY() - (player.getVelocidade()*1.4));
         else pulando = false;
      
      }else{
         pulando = false;
      }
   }


   public void calcularColisao(){
      Rectangle rp = new Rectangle((int)player.getX(), (int)player.getY(), (int)player.getLargura(), (int)player.getAltura());
      for(int i = 0; i < gerenciadorObjetos.objetos.size(); i++){
         if(gerenciadorObjetos.objetos.get(i) != null){
            //melhorar
            if(rp.intersects(gerenciadorObjetos.objetos.get(i).getHitbox())){
               player.setMover(false);
            }else{
               player.setMover(true);
            }
         }
      }
   }
}
