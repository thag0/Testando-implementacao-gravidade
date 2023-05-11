package entidade;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entidade{
   Rectangle hitbox;
   private double velocidadePadrao = 0;
   private double forcaPulo = 10;
   private boolean mover = true;

   public double xPadrao = 0;
   public double yPadrao = 0;

   public Player(){
      setAltura(20);
      setLargura(20);
      setVelocidade(4);
      setX(0);
      setY(0);
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


   public double getForcaPulo() {
      return forcaPulo;
   }


   public void setForcaPulo(double forcaPulo) {
      this.forcaPulo = forcaPulo;
   }


   public void desenhar(Graphics2D g2){
      g2.setColor(Color.red);
      g2.fillRoundRect((int)getX(), (int)getY(), (int)getLargura(), (int)getAltura(), 10, 10);
   }


   public void setPosicao(double x, double y){
      setX(x);
      setY(y);
   }


   public Rectangle getHitbox(){
      hitbox = new Rectangle((int)getX(), (int)getY(), (int)getLargura(), (int)getAltura());
      return this.hitbox;
   }
}
