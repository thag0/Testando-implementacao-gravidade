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
      capturarTeclas();
      aplicarGravidade();
      calcularColisao();
   }


   private void aplicarGravidade(){
      if(podeCair){
         if(player.y <= (painelPrincipal.altura-player.altura-forcaGravitacional) && player.mover){
            // forcaGravitacional += 0.23;
            forcaGravitacional = 0.2 + (forcaGravitacional*1.01);
            player.y = player.y + forcaGravitacional;
   
         }else{
            forcaGravitacional = 0;
         }
      }
   }


   private void capturarTeclas(){
      if(leitorTeclado.enter){//resetar variaveis
         player.setPosicao(player.xPadrao, player.yPadrao);
         forcaGravitacional = 0;
      }
      if(leitorTeclado.a && ((player.x - player.velocidade) >= 0)){
         player.x -= player.velocidade;
      }
      if(leitorTeclado.d && ((player.x + player.velocidade) <= (painelPrincipal.largura-player.largura))){
         player.x += player.velocidade;
      }
      if(leitorTeclado.setaCima){
         player.forcaPulo += 0.1;
      }
      if(leitorTeclado.setaBaixo){
         player.forcaPulo -= 0.1;
      }

      gerenciarPulo();
   }


   public void gerenciarPulo(){
      if(leitorTeclado.espaco && podePular){
         pulando = true;
         podeCair = true;
         playerY0 = player.y;
      }

      if(podeCair){
         if(pulando){
            player.y = player.y - (Math.exp(player.forcaPulo * 0.21) ) + forcaGravitacional;
         }
         if(player.y >= playerY0) pulando = false;
      }
   }


   public void calcularColisao(){
      boolean colidindo = false;
      for(int i = 0; i < gerenciadorObjetos.objetos.size(); i++){
         if(gerenciadorObjetos.objetos.get(i) != null){
            if(player.getHitbox().intersects(gerenciadorObjetos.objetos.get(i).hitbox)){
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
