package objetos;

import java.awt.Color;
import java.awt.Rectangle;

public class Plataforma extends Objeto{

   public Plataforma(double x, double y, double largura, double altura){
      this.x = x;
      this.y = y;
      this.largura = largura;
      this.altura = altura;
      colisao = true;
      this.cor = Color.GRAY;

      setHitbox(new Rectangle((int)this.x, (int)this.y, (int)this.largura, (int)this.altura));
   }
}
