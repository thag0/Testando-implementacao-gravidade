package structure;

import entidade.Player;
import objetos.GerenciadorObjetos;
import render.PainelPrincipal;

public class Logica{
   LeitorTeclado leitorTeclado;
   PainelPrincipal painelPrincipal;
   GerenciadorObjetos gerenciadorObjetos;
   Player player;
   
   //movimento
   public double forcaGravitacional = 0;
   public boolean pulando = false, podePular = true, podeCair = true;
   double playerY0;//y inicial

   public Logica(PainelPrincipal painelPrincipal){
      this.painelPrincipal = painelPrincipal;
      this.leitorTeclado = painelPrincipal.leitorTeclado;
      this.player = painelPrincipal.player;
      this.gerenciadorObjetos = painelPrincipal.gerenciadorObjetos;
   }

   public void atualizar(){
      movimentarPlayer();
      aplicarGravidade();
      calcularColisao();
   }


   private void aplicarGravidade(){
      if(podeCair){
         if(player.getY() <= (painelPrincipal.altura-player.getAltura()-forcaGravitacional) && player.getMover()){
            // forcaGravitacional += 0.23;
            forcaGravitacional = 0.2 + (forcaGravitacional*1.011);
            player.setY(player.getY()+forcaGravitacional);
   
         }else{
            forcaGravitacional = 0;
         }
      }
   }


   private void movimentarPlayer(){
      if(leitorTeclado.enter){//resetar variaveis
         player.setX(player.xPadrao);
         player.setY(player.yPadrao);
         forcaGravitacional = 0;
      }
      if(leitorTeclado.a && ((player.getX() - player.getVelocidade()) >= 0)){
         player.setX(player.getX() - player.getVelocidade());
      }
      if(leitorTeclado.d && ((player.getX() + player.getVelocidade()) <= (painelPrincipal.largura-player.getLargura()))){
         player.setX(player.getX() + player.getVelocidade());
      }

      gerenciarPulo();
   }


   public void gerenciarPulo(){
      if(leitorTeclado.espaco && podePular){
         pulando = true;
         podeCair = true;
         playerY0 = player.getY();
      }

      if(podeCair){
         if(pulando){
            player.setY(player.getY() - (Math.exp(player.getForcaPulo() * 0.21) ) + forcaGravitacional);
         }
         if(player.getY() >= playerY0) pulando = false;
      }
   }


   public void calcularColisao(){
      boolean colidindo = false;
      for(int i = 0; i < gerenciadorObjetos.objetos.size(); i++){
         if(gerenciadorObjetos.objetos.get(i) != null){
            //melhorar
            if(player.getHitbox().intersects(gerenciadorObjetos.objetos.get(i).getHitbox())){
               colidindo = true;
               break;
            }
         }
      }
      if(colidindo){
         pulando = false;
         podeCair = false;
         podePular = true;
         forcaGravitacional = 0;
      }else{
         podeCair = true;
      }
   }
}
