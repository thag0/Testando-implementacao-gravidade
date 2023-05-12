package objetos;

import java.awt.Color;
import java.awt.Rectangle;

import entidade.Entidade;

public class Objeto extends Entidade{
   public boolean colisao = false;
   public Color cor = Color.DARK_GRAY;
   public Rectangle hitbox;

   public void setHitbox(Rectangle hitbox){
      this.hitbox = hitbox;
   }
}
