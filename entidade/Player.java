package entidade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entidade{
   Rectangle hitbox;
   private double velocidadePadrao = 0;
   private boolean mover = true;

   public Player(){
      setAltura(20);
      setLargura(20);
      setVelocidade(3);
      setX(300);
      setY(200);
      hitbox = new Rectangle((int)getLargura(), (int)getAltura());
   }


   public double getVelocidadePadrao() {
      return velocidadePadrao;
   }


   public void setVelocidadePadrao(double velocidadePadrao){
      this.velocidadePadrao = velocidadePadrao;
   }


   public boolean getMover() {
      return mover;
   }


   public void setMover(boolean mover) {
      this.mover = mover;
   }


   public void desenhar(Graphics2D g2){
      g2.setColor(Color.WHITE);
      g2.fillRoundRect((int)getX(), (int)getY(), (int)getLargura(), (int)getAltura(), 10, 10);
   }


   public void setPosicao(double x, double y){
      setX(x);
      setY(y);
   }


   public Rectangle getHitbox(){
      return this.hitbox;
   }
}
