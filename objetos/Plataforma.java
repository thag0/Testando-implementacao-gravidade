package objetos;

import java.awt.Color;
import java.awt.Rectangle;

public class Plataforma extends Objeto{

   public Plataforma(double x, double y, double largura, double altura){
      setX(x);
      setY(y);
      setLargura(largura);
      setAltura(altura);
      setColisao(true);
      setCor(Color.GRAY);

      setHitbox(new Rectangle((int)getX(), (int)getY(), (int)getLargura(), (int)getAltura()));
   }
}
