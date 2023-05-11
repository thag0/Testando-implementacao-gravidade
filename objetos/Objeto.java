package objetos;

import java.awt.Color;
import java.awt.Rectangle;

import entidade.Entidade;

public class Objeto extends Entidade{
   private boolean colisao = false;
   private Color cor = Color.DARK_GRAY;
   private Rectangle hitbox;


   public Rectangle getHitbox(){
      return hitbox;
   }


   public void setHitbox(Rectangle hitbox) {
      this.hitbox = hitbox;
   }


   public Color getCor() {
      return cor;
   }


   public void setCor(Color cor) {
      this.cor = cor;
   }


   public boolean isColisao(){
      return colisao;
   }


   public void setColisao(boolean colisao) {
      this.colisao = colisao;
   }
}
