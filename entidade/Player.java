package entidade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entidade{
   private Rectangle hitbox;
   public double velocidadePadrao = 0;
   public double forcaPulo = 10;
   public boolean mover = true;

   public double xPadrao = 0;
   public double yPadrao = 0;

   public Player(){
      altura = 20;
      largura = 20;
      velocidade = 4;
      x = xPadrao;
      y = yPadrao;
   }


   public void desenhar(Graphics2D g2){
      g2.setColor(Color.red);
      g2.fillRoundRect((int)this.x, (int)this.y, (int)this.largura, (int)this.altura, 10, 10);
   }


   public void setPosicao(double x, double y){
      this.x = x;
      this.y = y;
   }


   public Rectangle getHitbox(){
      hitbox = new Rectangle((int)this.x, (int)this.y, (int)this.largura, (int)this.altura);
      return this.hitbox;
   }
}
